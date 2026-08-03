package com.api.ecommerce.core.domain.exception;

public class EmailNotFoundException extends RuntimeException {
    
    public EmailNotFoundException ( String email ) {

        super("The email %s was not found.".formatted(email));
        
    }
}
