package com.api.ecommerce.core.application.dto.request.product;

import java.math.BigDecimal;

public record UpdateProductRequest (

    String name,

    BigDecimal price,

    String description

) {}
