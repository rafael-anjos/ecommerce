package com.api.ecommerce.core.application.dto.response.exception;

import java.time.LocalDateTime;

public record ErrorResponse(

    int status,

    String message,

    LocalDateTime timestamp
    
) {}
