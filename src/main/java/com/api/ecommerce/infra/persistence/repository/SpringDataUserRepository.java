package com.api.ecommerce.infra.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.infra.persistence.entity.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail ( String email );

    UserEntity findByEmail ( String email );

}
