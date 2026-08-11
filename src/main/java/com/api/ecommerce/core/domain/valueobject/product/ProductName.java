package com.api.ecommerce.core.domain.valueobject.product;

import com.api.ecommerce.core.domain.exception.InvalidNameException;

public class ProductName {

    private final String value;

    public ProductName ( String value ) {

        validate(value);

        this.value = normalize(value);

    }

    private void validate ( String value ) {

        if (value == null || value.isBlank()) {
            throw new InvalidNameException(value);
        }

        if (value.length() < 3) {
            throw new InvalidNameException(value);
        }

        if (value.length() > 100) {
            throw new InvalidNameException(value);
        }

    }

    private String normalize ( String value ) {

        return value.trim().toUpperCase();

    }

    public static ProductName of ( String value ) {

        return new ProductName(value);

    }

    public String value () {

        return value;

    }
    
}
