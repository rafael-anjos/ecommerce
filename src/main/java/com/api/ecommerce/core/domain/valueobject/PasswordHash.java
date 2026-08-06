package com.api.ecommerce.core.domain.valueobject;

public final class PasswordHash {

    private final String value;

    public PasswordHash(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.value = value;

    }

    public static PasswordHash of ( String value ) {

        return new PasswordHash(value);

    }

    public String value () {

        return value;

    }

}
