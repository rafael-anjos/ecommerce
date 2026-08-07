package com.api.ecommerce.core.application.dto.response.user;

import java.util.UUID;

public record GetUserResponse (

    UUID id,

    String name,

    String email
    
) {}
