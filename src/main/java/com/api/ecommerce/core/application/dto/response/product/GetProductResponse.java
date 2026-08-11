package com.api.ecommerce.core.application.dto.response.product;

import java.math.BigDecimal;

public record GetProductResponse(

    String name,

    String description,

    BigDecimal price,

    int quantity,

    String sku

) {}
