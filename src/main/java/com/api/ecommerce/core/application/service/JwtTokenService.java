package com.api.ecommerce.core.application.service;

import com.api.ecommerce.core.domain.entity.User;

public interface JwtTokenService {

    String generateToken ( User user );
    
}
