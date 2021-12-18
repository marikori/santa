package com.secret.santa.service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.secret.santa.exceptions.BadRequestException;
import com.secret.santa.exceptions.InternalServerErrorException;
import com.secret.santa.model.SantaMappingObject;
import com.secret.santa.model.TeammateObject;
import com.secret.santa.model.TeammateObjectAllOfResponse;
import com.secret.santa.repository.TeammateRepository;

@Service
public class TeammateService {
    
    private TeammateRepository teammateRepository;
    
    public TeammateService(TeammateRepository teammateRepository) {
        this.teammateRepository = teammateRepository;
    }
    
    public TeammateObject createTeammate(String name) {
        
        try {
            if (teammateRepository.createTeammate(name) > 0) {
                TeammateObject retVal = new TeammateObject()
                        .status(HttpStatus.CREATED.value())
                        .response(new TeammateObjectAllOfResponse().name(name));
                
                calculateGame();
                
                return retVal;
                
            } else {
                throw new InternalServerErrorException("Failed to create team mate.");
            }
            
        } catch (DuplicateKeyException e) {
            throw new BadRequestException(String.format("Teammate %s already exists.", name));
        }
    }
    
    @Async("calculateGameExec")
    public void calculateGame() {
        int currentYear = Year.now().getValue();
        List<SantaMappingObject> existingGameMapping = teammateRepository.getSantaMappings(currentYear);
        List<TeammateObjectAllOfResponse> existingTeammates = teammateRepository.getTeammates();
        
        List<TeammateObjectAllOfResponse> teammatesWithSanta = existingTeammates.stream()
                .filter(existingGameMapping::contains)
                .collect(Collectors.toList());
        
        // TODO implement coupling of teammates
    }
}
