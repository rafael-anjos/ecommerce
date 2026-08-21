package com.api.ecommerce.core.application.dto.request.cart;

import java.util.UUID;

public record RemoveItemInput (

    UUID cartId,

    UUID productId

) {}
