package com.api.ecommerce.infra.persistence.repository;

import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.infra.persistence.entity.UserEntity;
import com.api.ecommerce.infra.persistence.mapper.UserMapper;

import java.util.Optional;
import java.util.UUID;

import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.UserNotFoundException;

public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository repository;

    public JpaUserRepositoryAdapter ( SpringDataUserRepository repository ) {
        this.repository = repository;
    }

    public User save ( User user ) {

        UserEntity entity = UserMapper.toEntity(user);

        UserEntity saved = repository.save(entity);

        return UserMapper.toDomain(saved);

    }

    public void delete ( String email ) {

        repository.delete(repository.findByEmail(email));

    }

    public Optional<User> findById ( UUID id ) {

        return repository.findById(id).map(UserMapper::toDomain);

    }

    public User findByEmail ( String email ) {

        UserEntity entity = repository.findByEmail(email);

        return UserMapper.toDomain(entity);

    }
    
    public boolean existsByEmail ( String email ) {

        return repository.existsByEmail(email);

    }
}
