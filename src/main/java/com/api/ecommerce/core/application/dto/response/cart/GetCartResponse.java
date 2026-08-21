package com.api.ecommerce.core.application.dto.response.cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.api.ecommerce.core.domain.entity.CartItem;
import com.api.ecommerce.core.domain.valueobject.cart.CartStatus;

public record GetCartResponse (

    UUID cartId,

    UUID userId,

    int itemsQuantity,

    BigDecimal valueCart,

    List<CartItem> items,

    CartStatus status

) {}
