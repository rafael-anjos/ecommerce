package com.api.ecommerce.core.application.dto.request.auth;

public record LoginRequest (

    String email,

    String password
    
) {}