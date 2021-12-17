package com.secret.santa.exceptions;

public class SantaRuntimeException extends RuntimeException {
    
    private static final long serialVersionUID = -5339416955758975556L;
    
    public SantaRuntimeException() {
        super();
    }
    
    public SantaRuntimeException(String msg) {
        super(msg);
    }
    
    public SantaRuntimeException(Throwable cause) {
        super(cause);
    }
    
    public SantaRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
