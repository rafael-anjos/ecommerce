package com.api.ecommerce.core.domain.repository;

import com.api.ecommerce.core.domain.entity.User;

public interface UserRepository {
    
    User save ( User user );

    boolean existsByEmail ( String email );
    
}
