package com.secret.santa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secret.santa.model.SantaMappingObject;

@Repository
public class TeammateRepository {
    private TeammateMapper teammateMapper;
    
    public TeammateRepository(TeammateMapper teammateMapper) {
        this.teammateMapper = teammateMapper;
    }
    
    public int createTeammate(String name) {
        return teammateMapper.createTeammate(name);
    }
    
    public int updateCurrentSantaName(String receiverName, String santaName) {
        return teammateMapper.updateCurrentSantaName(receiverName, santaName);
    }
    
    public List<String> getTeammates(){
        return teammateMapper.getTeammates();
    }
    
    public List<SantaMappingObject> getCurrentSantaMappings() {
        return teammateMapper.getSantasCurrentYear();
    }
    
    public Map<String, List<String>> getPastSantaMappings() {
        Map<String, List<String>> retVal = new HashMap<>();
        
        for (SantaMappingObject santaMapping : teammateMapper.getSantasOneYearBack()) {
            List<String> notAllowedSantas = new ArrayList<>();
            notAllowedSantas.add(santaMapping.getSanta());
            retVal.put(santaMapping.getReceiver(), notAllowedSantas);
        }
        
        for (SantaMappingObject santaMapping : teammateMapper.getSantasTwoYearBack()) {
            retVal.get(santaMapping.getReceiver()).add(santaMapping.getSanta());
        }
        
        return retVal;
    }
}
