package com.api.ecommerce.core.domain.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException ( ) {
        
        super("Resource was not found.");

    }
}
