package com.secret.santa.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TeammateRepository {
    private TeammateMapper teammateMapper;
    
    public TeammateRepository(TeammateMapper teammateMapper) {
        this.teammateMapper = teammateMapper;
    }
    
    public int createTeammate(String name) {
        return teammateMapper.createTeammate(name);
    }
}
