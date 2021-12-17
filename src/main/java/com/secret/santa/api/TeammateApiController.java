package com.secret.santa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.secret.santa.model.TeammateObject;
import com.secret.santa.service.TeammateService;


import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-17T17:58:40.017983Z[Europe/Dublin]")
@Controller
@RequestMapping("${openapi.secretSanta.base-path:/api/v1/santa}")
public class TeammateApiController implements TeammateApi {

    private TeammateService teammateService;
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TeammateApiController(NativeWebRequest request, TeammateService teammateService) {
        this.request = request;
        this.teammateService = teammateService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @Override
    public ResponseEntity<TeammateObject> teammatePost(String name) {
        TeammateObject response = teammateService.createTeammate(name);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
