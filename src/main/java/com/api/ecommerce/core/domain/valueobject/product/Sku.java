package com.api.ecommerce.core.domain.valueobject.product;

public class Sku {
    
    private final String value;

    public Sku ( String value ) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }

        this.value = normalize(value);

    }

    private String normalize ( String value ) {

        return value.trim().toUpperCase();

    }

    public static Sku of ( String value ) {

        return new Sku(value);

    }

    public String value () {

        return value;
        
    }
}
