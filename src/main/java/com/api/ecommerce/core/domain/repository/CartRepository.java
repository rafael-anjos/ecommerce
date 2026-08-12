package com.api.ecommerce.core.domain.repository;

import com.api.ecommerce.core.domain.entity.Cart;

public interface CartRepository {
    
    Cart save ( Cart cart );
    
}
