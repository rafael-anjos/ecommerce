package com.api.ecommerce.core.domain.exception;

public class CartAlreadyExistsException extends RuntimeException {

    public CartAlreadyExistsException ( String message ) {

        super(message);
        
    }
    
}
