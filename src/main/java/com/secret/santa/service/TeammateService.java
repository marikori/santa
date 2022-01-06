package com.secret.santa.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;

import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import com.secret.santa.exceptions.BadRequestException;
import com.secret.santa.exceptions.InternalServerErrorException;
import com.secret.santa.exceptions.OrePropertyException;
import com.secret.santa.model.SantasObject;
import com.secret.santa.model.TeammateObject;
import com.secret.santa.repository.TeammateRepository;

@Service
public class TeammateService {
    
    private Logger log = LoggerFactory.getLogger(TeammateService.class);
    private TeammateRepository teammateRepository;
    
    public TeammateService(TeammateRepository teammateRepository) {
        this.teammateRepository = teammateRepository;
    }
    
    
    public SantasObject getSantasObject() {
        return new SantasObject()
                .status(HttpStatus.OK.value())
                .response(teammateRepository.getCurrentSantaMappings());
    }
    
    
    public SantasObject resetSantasObjects() {
        teammateRepository.moveSantasNewYear();
        return new SantasObject()
                .status(HttpStatus.OK.value())
                .response(teammateRepository.getCurrentSantaMappings());
    }
    
    
    public TeammateObject createTeammate(String name) {
        
        try {
            if (teammateRepository.createTeammate(name) > 0) {
                TeammateObject retVal = new TeammateObject()
                        .status(HttpStatus.CREATED.value())
                        .response(name);
                
                calculateGame(true, teammateRepository.getTeammates(), teammateRepository.getPastSantaMappings());
                
                return retVal;
                
            } else {
                throw new InternalServerErrorException("Failed to create team mate.");
            }
            
        } catch (DuplicateKeyException e) {
            throw new BadRequestException(String.format("Teammate %s already exists.", name));
        }
    }
    
    
    private void calculateGame(boolean visualize, List<String> teammates, Map<String, List<String>> pastSantaMappings) {
        DefaultDirectedGraph<String, SantaEdge> allowedEdgesGraph = new DefaultDirectedGraph<>(SantaEdge.class);
        
        List<String> teammatesInGraph = new ArrayList<>();
        
        // build directed graph with allowed edges between receivers and santas 
        for (String teammate : teammates) {
            allowedEdgesGraph.addVertex(teammate);
            
            for (String teammateInGraph : teammatesInGraph) {
                if ((pastSantaMappings.get(teammate) == null) || (! pastSantaMappings.get(teammate).contains(teammateInGraph))) {
                    allowedEdgesGraph.addEdge(teammate, teammateInGraph);
                }
                if ((pastSantaMappings.get(teammateInGraph) == null) || (! pastSantaMappings.get(teammateInGraph).contains(teammate))) {
                    allowedEdgesGraph.addEdge(teammateInGraph, teammate);
                }
            }
            
            teammatesInGraph.add(teammate);
        }
        
        if (visualize) {
            visualize(allowedEdgesGraph, "allowedEdgesGraph.png");
        }
        
        if (teammates.size() > 1) {
            Map<String, List<String>> santaPath = new LinkedHashMap<>();
            santaPath.put(teammates.get(0), new ArrayList<>());
            // jgrapht does not have Hamiltonian cycle algorithm for directed graphs :`( - had to implement my own
            updateCurrentSantaNames(getSantaPathGraph(allowedEdgesGraph, santaPath));
        }
    }
    
    
    private Map<String, List<String>> getSantaPathGraph(DefaultDirectedGraph<String, SantaEdge> allowedEdgesGraph, Map<String, List<String>> santaPath) {
        Iterator<Entry<String, List<String>>> santaPathIterator = santaPath.entrySet().iterator();
        Entry<String, List<String>> lastHeadVertex = null;
        
        while (santaPathIterator.hasNext()) {
            lastHeadVertex = santaPathIterator.next();
        }
        
        if (lastHeadVertex == null) {
            // root vertex exhausted all edges - nowhere to move
            throw new OrePropertyException();
        }
        
        List <String> allowedHeads = getHeads(allowedEdgesGraph.outgoingEdgesOf(lastHeadVertex.getKey()));
        // remove all already tried head vertices (i.e. all already tried edges)
        allowedHeads.removeAll(lastHeadVertex.getValue());
        // remove all vertices already in the path (teammate can receive only from one santa)
        allowedHeads.removeAll(santaPath.keySet());
        
        if (allowedHeads.isEmpty()) {
            // there is no edge which would not have already been tried
            
            if ((santaPath.keySet().size() < allowedEdgesGraph.vertexSet().size()) 
                    || ! allowedEdgesGraph.containsEdge(lastHeadVertex.getKey(), santaPath.entrySet().iterator().next().getKey())) {
                // this is not the last vertex OR there is no edge this (last) vertex and the root vertex 
                // try to move back to previous to see if there are any vertices to explore
                santaPathIterator.remove();
            
            } else {
                // this is last vertex - i.e. all vertices are in santa path (we found Hamiltonian path)
                return santaPath;
            }
        
        } else {
            String nextHeadVertex = allowedHeads.get(0);
            lastHeadVertex.getValue().add(nextHeadVertex);
            santaPath.put(nextHeadVertex, new ArrayList<>());
        }
        
        return getSantaPathGraph(allowedEdgesGraph, santaPath);
    }
    
    
    private List<String> getHeads(Set<SantaEdge> edges) {
        List<String> retVal = new ArrayList<>();
        
        for (SantaEdge edge : edges) {
            retVal.add((String) edge.getTarget());
        }
        
        return retVal;
    }
    
    
    private void updateCurrentSantaNames(Map<String, List<String>> santaPath) {
        String firstSanta = "";
        String receiver = "";
        
        for (String santa : santaPath.keySet()) {
            firstSanta = firstSanta.isEmpty() ? santa : firstSanta;
            
            if (! receiver.isEmpty())
                teammateRepository.updateCurrentSantaName(receiver, santa);
            
            receiver = santa;
        }
        
        teammateRepository.updateCurrentSantaName(receiver, firstSanta);
    }
    
    
    private void visualize(Graph<String, SantaEdge> graph, String name) {
        File imgFile = new File(name);
        JGraphXAdapter<String, SantaEdge> graphAdapter = new JGraphXAdapter<>(graph);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        try {
            ImageIO.write(image, "PNG", imgFile);
        } catch (IOException e) {
            log.warn("Failed to create PNG image.");
        }
    }
}
