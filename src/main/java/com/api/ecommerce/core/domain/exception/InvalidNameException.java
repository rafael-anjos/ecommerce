package com.api.ecommerce.core.domain.exception;

public class InvalidNameException extends RuntimeException {
    
    public InvalidNameException ( String name ) {

        super("Name %s is invalid.".formatted(name));
        
    }
}
