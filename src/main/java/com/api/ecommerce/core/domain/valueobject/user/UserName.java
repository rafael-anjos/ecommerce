package com.api.ecommerce.core.domain.valueobject.user;

import com.api.ecommerce.core.domain.exception.InvalidNameException;

public final class UserName {

    private final String value;

    public UserName ( String value ) {

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

    public static UserName of ( String value ) {

        return new UserName(value);

    }

    public String value () {

        return value;

    }
    
}
