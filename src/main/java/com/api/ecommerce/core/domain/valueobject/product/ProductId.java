package com.api.ecommerce.core.domain.valueobject.product;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.InvalidIdException;

public class ProductId {

    private final UUID value;

    public ProductId ( UUID value ) {

        if(value == null) {
            throw new InvalidIdException("Product id cannot be null.");
        }

        this.value = value;

    }

    public static ProductId generate () {

        return new ProductId(UUID.randomUUID());

    }

    public static ProductId of ( UUID value ) {

        return new ProductId(value);

    }

    public UUID value () {

        return value;

    }

    public String toString () {

        return value.toString();
        
    }
    
}
