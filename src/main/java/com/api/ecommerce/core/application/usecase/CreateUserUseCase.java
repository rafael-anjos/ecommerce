package com.api.ecommerce.core.application.usecase;

import com.api.ecommerce.core.application.dto.request.CreateUserRequest;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.EmailAlreadyExistsException;
import com.api.ecommerce.core.domain.repository.UserRepository;

public class CreateUserUseCase {
    
    private final UserRepository repository;

    public CreateUserUseCase ( UserRepository repository ) {
        this.repository = repository;
    }

    public void execute ( CreateUserRequest request ) {

        if (repository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }

        User user = new User (

            request.name(), 

            request.email()
            
        );

        repository.save(user);
        
    }
}
