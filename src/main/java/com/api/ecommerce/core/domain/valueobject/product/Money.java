package com.api.ecommerce.core.domain.valueobject.product;

import java.math.BigDecimal;

public class Money {
    
    private final BigDecimal value;

    public Money ( BigDecimal value ) {

        validate(value);

        this.value = value;

    }

    private void validate ( BigDecimal value ) {

        if (value == null) {
            throw new IllegalArgumentException("Price cannot be null.");
        }

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

    }

    public static Money of ( BigDecimal value ) {

        return new Money(value);

    }

    public Money add ( Money other ) {

        return new Money(this.value.add(other.value));

    }

    public static Money zero () {

        return new Money(BigDecimal.ZERO);
        
    }

    public BigDecimal value () {

        return value;

    }
    
}
