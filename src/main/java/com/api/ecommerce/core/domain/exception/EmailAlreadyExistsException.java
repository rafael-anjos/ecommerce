package com.api.ecommerce.core.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    
    public EmailAlreadyExistsException ( String email ) {

        super("The email %s is already registered.".formatted(email));
        
    }
}
