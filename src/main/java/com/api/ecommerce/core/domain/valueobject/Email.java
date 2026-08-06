package com.api.ecommerce.core.domain.valueobject;

import com.api.ecommerce.core.domain.exception.InvalidEmailException;

public final class Email {
    
    private final String value;

    public Email ( String value ) {

        validate(value);

        this.value = normalize(value);

    }

    private void validate ( String value ) {

        if (value == null || value.isBlank()) {
            throw new InvalidEmailException(value);
        }

        if (!value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidEmailException(value);
        }

    }

    public static Email of ( String value ) {

        return new Email(value);
        
    }

    private String normalize ( String value ) {

        return value.trim().toLowerCase();

    }

    public String value () {

        return value;

    }

}
