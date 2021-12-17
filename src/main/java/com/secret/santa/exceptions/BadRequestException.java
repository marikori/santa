package com.secret.santa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends SantaRuntimeException {
    
    private static final long serialVersionUID = 8837699583682658541L;
    
    public BadRequestException() {
        super();
    }
    
    public BadRequestException(String msg) {
        super(msg);
    }
    
    public BadRequestException(Throwable cause) {
        super(cause);
    }
    
    public BadRequestException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
