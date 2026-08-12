package com.api.ecommerce.infra.persistence.mapper;

import java.util.List;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.entity.CartItem;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.user.UserId;
import com.api.ecommerce.infra.persistence.entity.CartEntity;
import com.api.ecommerce.infra.persistence.entity.CartItemEntity;

public class CartMapper {

    private final CartItemMapper cartItemMapper;

    public CartMapper ( CartItemMapper cartItemMapper ) {
        this.cartItemMapper = cartItemMapper;
    }
    
    public CartEntity toEntity ( Cart cart ) {

        CartEntity entity = new CartEntity(
            cart.getId().value(), 
            cart.getUserId().value(), 
            null, 
            cart.getCreatedAt(), 
            cart.getUpdatedAt()
        );

        List<CartItemEntity> items = cart.getItems().stream()
        .map(cartItemMapper::toEntity)
        .peek(item -> item.setCart(entity))
        .toList();

        entity.setItems(items);

        return entity;
        
    }

    public Cart toDomain ( CartEntity entity ) {

        List<CartItem> items = entity.getItems().stream()
        .map(cartItemMapper::toDomain)
        .toList();

        return Cart.restore(
            CartId.of(entity.getId()), 
            UserId.of(entity.getUserId()), 
            items, 
            entity.getCreatedAt(), 
            entity.getUpdatedAt()
        );

    }
}
