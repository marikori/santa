package com.secret.santa.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-17T17:58:40.017983Z[Europe/Dublin]")
@Controller
@RequestMapping("${openapi.secretSanta.base-path:/api/v1/santa}")
public class SantasApiController implements SantasApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SantasApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
