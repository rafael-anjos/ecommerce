package com.api.ecommerce.core.domain.valueobject.product;

public class Quantity {
    
    private final int value;

    public Quantity ( int value ) {

        if (value < 0) {
            throw new IllegalArgumentException("Quantity from stock cannot be negative.");
        }

        this.value = value;

    }

    public Quantity decrease ( int quantity ) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (quantity > value) {
            throw new IllegalArgumentException("Insufficient stock.");
        }

        return new Quantity ( value - quantity );

    }

    public Quantity increase ( int quantity ) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        return new Quantity ( value + quantity );
        
    }

    public static Quantity of ( int value ) {

        return new Quantity(value);

    }

    public int value () {

        return value;
        
    }
}
