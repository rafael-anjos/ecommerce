package com.api.ecommerce.core.application.dto.request.cart;

import java.util.UUID;

public record AddItemInput (

    UUID cartId,

    UUID productId,

    int quantity

) {}
