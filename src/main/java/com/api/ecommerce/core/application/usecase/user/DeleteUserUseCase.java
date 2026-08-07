package com.api.ecommerce.core.application.usecase.user;

import com.api.ecommerce.core.domain.exception.EmailNotFoundException;
import com.api.ecommerce.core.domain.repository.UserRepository;

public class DeleteUserUseCase {
    
    private final UserRepository repository;

    public  DeleteUserUseCase ( UserRepository repository ) {
        this.repository = repository;
    }

    public void execute ( String email) {

        if (!repository.existsByEmail(email)){
            throw new EmailNotFoundException(email);
        }

        repository.delete(email);

    }
}
