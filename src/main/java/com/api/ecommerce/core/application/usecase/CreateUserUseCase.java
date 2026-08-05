package com.api.ecommerce.core.application.usecase;

import com.api.ecommerce.core.application.dto.request.CreateUserRequest;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.EmailAlreadyExistsException;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.security.PasswordHasher;

public class CreateUserUseCase {
    
    private final UserRepository repository;
    private final PasswordHasher passwordHasher;

    public CreateUserUseCase ( UserRepository repository, PasswordHasher passwordHasher ) {
        this.repository = repository;
        this.passwordHasher = passwordHasher;
    }

    public void execute ( CreateUserRequest request ) {

        if (repository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }

        String hashedPassword = passwordHasher.hash(request.password());

        User user = new User (

            request.name().toUpperCase(), 

            request.email(),

            hashedPassword
            
        );

        repository.save(user);
        
    }
}
