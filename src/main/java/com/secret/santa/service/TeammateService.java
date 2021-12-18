package com.secret.santa.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.secret.santa.exceptions.BadRequestException;
import com.secret.santa.exceptions.InternalServerErrorException;
import com.secret.santa.model.TeammateObject;
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
                        .response(name);
                
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
    }
}
