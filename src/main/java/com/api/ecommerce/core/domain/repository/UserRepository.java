package com.api.ecommerce.core.domain.repository;

import com.api.ecommerce.core.domain.entity.User;

public interface UserRepository {
    
    User save ( User user );

    void delete ( String email );

    User findByEmail ( String email );

    boolean existsByEmail ( String email );
    
}
