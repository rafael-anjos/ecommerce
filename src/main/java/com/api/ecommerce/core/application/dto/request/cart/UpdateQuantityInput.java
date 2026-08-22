package com.api.ecommerce.core.application.dto.request.cart;

import java.util.UUID;

public record UpdateQuantityInput (

    UUID cartId,

    UUID cartItemUuid
) {}
