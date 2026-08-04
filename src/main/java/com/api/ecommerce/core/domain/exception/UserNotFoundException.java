package com.api.ecommerce.core.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException ( ) {
        
        super("The user was not found.");

    }
}
