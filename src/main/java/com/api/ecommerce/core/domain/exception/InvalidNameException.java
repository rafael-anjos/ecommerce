package com.api.ecommerce.core.domain.exception;

public class InvalidNameException extends RuntimeException {
    
    public InvalidNameException ( String name ) {

        super("The name %s is invalid.".formatted(name));
        
    }
}
