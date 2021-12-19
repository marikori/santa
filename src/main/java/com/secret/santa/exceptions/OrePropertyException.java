package com.secret.santa.exceptions;

public class OrePropertyException  extends SantaRuntimeException {
    private static final long serialVersionUID = -5683624743295561231L;

    public OrePropertyException() {
        super();
    }
    
    public OrePropertyException(String msg) {
        super(msg);
    }
    
    public OrePropertyException(Throwable cause) {
        super(cause);
    }
    
    public OrePropertyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
