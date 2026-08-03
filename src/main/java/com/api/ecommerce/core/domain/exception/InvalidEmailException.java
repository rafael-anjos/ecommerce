package com.api.ecommerce.core.domain.exception;

public class InvalidEmailException extends RuntimeException {
    
    public InvalidEmailException ( String email ) {

        super("The email %s is invalid.".formatted(email));
        
    }
}
