package com.api.ecommerce.core.application.dto.request.product;

import java.math.BigDecimal;

public record CreateProductRequest(

    String name,

    String description,

    BigDecimal price,

    int quantity,

    String sku
    
) {}
