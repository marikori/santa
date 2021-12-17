package com.secret.santa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends SantaRuntimeException {
    
    private static final long serialVersionUID = 1476856906381654405L;
    
    public InternalServerErrorException() {
        super();
    }
    
    public InternalServerErrorException(String msg) {
        super(msg);
    }
    
    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }
    
    public InternalServerErrorException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
