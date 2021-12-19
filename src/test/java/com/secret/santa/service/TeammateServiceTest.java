package com.secret.santa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import com.secret.santa.model.SantaMappingObject;
import com.secret.santa.model.SantasObject;
import com.secret.santa.repository.TeammateRepository;

class TeammateServiceTest {
    
    private TeammateRepository teammateRepositoryMock;
    private TeammateService teammateService;
    
    private SantaMappingObject santaMappingObject1 = new SantaMappingObject().santa("santa1").receiver("receiver1");
    private SantaMappingObject santaMappingObject2 = new SantaMappingObject().santa("santa2").receiver("receiver2");
    private List<SantaMappingObject> listOfSantaMappingObjects = new ArrayList<>();
    
    @BeforeEach
    void setUp() throws Exception {
        teammateRepositoryMock = Mockito.mock(TeammateRepository.class);
        teammateService = new TeammateService(teammateRepositoryMock);
        listOfSantaMappingObjects.add(santaMappingObject1);
        listOfSantaMappingObjects.add(santaMappingObject2);
    }
    
    @Test
    void testGetSantasObject() {
        Mockito.when(teammateRepositoryMock.getCurrentSantaMappings()).thenReturn(listOfSantaMappingObjects);
        assertEquals(new SantasObject().status(HttpStatus.OK.value()).response(listOfSantaMappingObjects), teammateService.getSantasObject());
    }

}
