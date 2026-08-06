package com.api.ecommerce.core.domain.exception;

public class InvalidEmailException extends RuntimeException {
    
    public InvalidEmailException ( String email ) {

        super("Email %s is invalid.".formatted(email));
        
    }
}
