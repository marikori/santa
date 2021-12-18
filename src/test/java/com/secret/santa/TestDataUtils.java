package com.secret.santa;

import java.util.Arrays;
import java.util.List;

import com.secret.santa.model.SantaMappingObject;
import com.secret.santa.model.TeammateObjectAllOfResponse;

public class TestDataUtils {
    public final static SantaMappingObject SANTA_MAPPING_OBJECT_1 = new SantaMappingObject()
            .santa("santa1").receiver("receiver1");
    public final static SantaMappingObject SANTA_MAPPING_OBJECT_2 = new SantaMappingObject()
            .santa("santa2").receiver("receiver2");
    public final static List<SantaMappingObject> LIST_OF_SANTA_MAPPING_OBJECTS = Arrays.asList(SANTA_MAPPING_OBJECT_1, SANTA_MAPPING_OBJECT_2);
    
    public final static TeammateObjectAllOfResponse TEAMMATE_OBJECT_1 = new TeammateObjectAllOfResponse().name("receiver1");
    public final static TeammateObjectAllOfResponse TEAMMATE_OBJECT_2 = new TeammateObjectAllOfResponse().name("receiver2");
    public final static List<TeammateObjectAllOfResponse> LIST_OF_TEAMMATE_OBJECTS_1 = Arrays.asList(TEAMMATE_OBJECT_1);
    public final static List<TeammateObjectAllOfResponse> LIST_OF_TEAMMATE_OBJECTS_2 = Arrays.asList(TEAMMATE_OBJECT_2);
}
