package com.api.ecommerce.core.application.dto.request.user;

public record CreateUserRequest (

    String name,

    String email,

    String password
    
) {}
