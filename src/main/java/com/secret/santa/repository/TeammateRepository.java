package com.secret.santa.repository;

import java.time.Year;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.secret.santa.exceptions.BadRequestException;
import com.secret.santa.model.SantaMappingObject;

@Repository
public class TeammateRepository {
    private TeammateMapper teammateMapper;
    
    public TeammateRepository(TeammateMapper teammateMapper) {
        this.teammateMapper = teammateMapper;
    }
    
    public int createTeammate(String name) {
        return 1; //teammateMapper.createTeammate(name);
    }
    
    public List<String> getTeammates(){
        return teammateMapper.getTeammates();
    }
    
    public List<SantaMappingObject> getSantaMappings(int year) {
        int currentYear = Year.now().getValue();
        if (currentYear - year == 0) {
            return teammateMapper.getSantasCurrentYear();
        } else if (currentYear - year == 1) {
            return teammateMapper.getSantasOneYearBack();
        } else if (currentYear - year == 2) {
            return teammateMapper.getSantasTwoYearBack();
        } else if (currentYear - year == 3) {
            return teammateMapper.getSantasThreeYearBack();
        }
        
        throw new BadRequestException();
    }
}
