package com.api.ecommerce.infra.persistence.mapper;

import com.api.ecommerce.core.domain.entity.CartItem;
import com.api.ecommerce.core.domain.valueobject.cart_item.CartItemId;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;
import com.api.ecommerce.infra.persistence.entity.CartItemEntity;

public class CartItemMapper {
    
    public CartItemEntity toEntity ( CartItem cartItem ) {

        return new CartItemEntity(
            cartItem.getId().value(), 
            cartItem.getProductId().value(), 
            cartItem.getQuantity().value()
        );

    }

    public CartItem toDomain ( CartItemEntity entity ) {

        return CartItem.restore(
            CartItemId.of(entity.getId()),
            ProductId.of(entity.getProductId()), 
            Quantity.of(entity.getQuantity())
        );

    }
}
