package com.secret.santa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.secret.santa.TestDataUtils;
import com.secret.santa.repository.TeammateRepository;

class TeammateServiceTest {
    
    private TeammateService teammateService;
    private TeammateRepository teammateRepositoryMock;
    
    @BeforeEach
    void setUp() throws Exception {
        this.teammateRepositoryMock = Mockito.mock(TeammateRepository.class);
        this.teammateService = new TeammateService(teammateRepositoryMock);
    }
    
    @Test
    void testCalculateGame() {
        int currentYear = Year.now().getValue();
        Mockito.when(teammateRepositoryMock.getSantaMappings(currentYear)).thenReturn(TestDataUtils.LIST_OF_SANTA_MAPPING_OBJECTS);
        Mockito.when(teammateRepositoryMock.getTeammates()).thenReturn(TestDataUtils.LIST_OF_TEAMMATE_OBJECTS_1);
        teammateService.calculateGame();
    }
    
    // TODO test coverage
}
