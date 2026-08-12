package com.api.ecommerce.infra.persistence.repository.cart;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.infra.persistence.entity.CartEntity;
import com.api.ecommerce.infra.persistence.mapper.CartItemMapper;
import com.api.ecommerce.infra.persistence.mapper.CartMapper;

public class JpaCartRepositoryAdapter implements CartRepository {
    
    private final SpringDataCartRepository repository;

    public JpaCartRepositoryAdapter ( SpringDataCartRepository repository ) {
        this.repository = repository;
    }

    public Cart save ( Cart cart ) {

        CartItemMapper itemMapper = new CartItemMapper();

        CartMapper mapper = new CartMapper(itemMapper);

        CartEntity entity = mapper.toEntity(cart);
        
        CartEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
        
    }
}
