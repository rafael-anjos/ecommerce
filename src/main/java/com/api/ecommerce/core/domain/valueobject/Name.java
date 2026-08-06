package com.api.ecommerce.core.domain.valueobject;

import com.api.ecommerce.core.domain.exception.InvalidNameException;

public final class Name {

    private final String value;

    public Name ( String value ) {

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

        if (!value.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            throw new InvalidNameException(value);
        }

    }

    private String normalize ( String value ) {

        return value.trim().toUpperCase();

    }

    public static Name of ( String value ) {

        return new Name(value);

    }

    public String value () {

        return value;

    }
    
}
