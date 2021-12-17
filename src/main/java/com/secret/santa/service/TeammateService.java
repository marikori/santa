package com.secret.santa.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
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
            teammateRepository.createTeammate(name);
            if (teammateRepository.createTeammate(name) > 0) {
                return new TeammateObject()
                        .status(HttpStatus.CREATED.value())
                        .response(name);
                
            } else {
                throw new InternalServerErrorException("Failed to create team mate.");
            }
        } catch (DuplicateKeyException e) {
            throw new BadRequestException(String.format("Teammate %s already exists.", name));
        }
        
    }
}
