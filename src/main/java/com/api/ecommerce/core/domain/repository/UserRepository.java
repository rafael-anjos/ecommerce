package com.api.ecommerce.core.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.api.ecommerce.core.domain.entity.User;

public interface UserRepository {
    
    User save ( User user );

    void delete ( String email );

    User findByEmail ( String email );

    Optional<User> findById ( UUID id );

    boolean existsByEmail ( String email );
    
}
