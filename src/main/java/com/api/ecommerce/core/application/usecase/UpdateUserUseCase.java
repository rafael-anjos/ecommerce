package com.api.ecommerce.core.application.usecase;

import java.util.UUID;

import com.api.ecommerce.core.application.dto.request.UpdateUserRequest;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.UserNotFoundException;
import com.api.ecommerce.core.domain.repository.UserRepository;

public class UpdateUserUseCase {
    
    private final UserRepository repository;

    public UpdateUserUseCase ( UserRepository repository ) {
        this.repository = repository;
    }

    public void execute ( UUID id, UpdateUserRequest request ) {

        User user = repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());

        user.update(
            request.name(), 
            request.email());

        repository.save(user);    

    }
}
