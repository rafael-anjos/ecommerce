package com.api.ecommerce.core.application.usecase.user;

import com.api.ecommerce.core.application.dto.request.user.CreateUserRequest;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.EmailAlreadyExistsException;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.security.PasswordHasher;
import com.api.ecommerce.core.domain.valueobject.user.Email;
import com.api.ecommerce.core.domain.valueobject.user.Name;
import com.api.ecommerce.core.domain.valueobject.user.Password;
import com.api.ecommerce.core.domain.valueobject.user.PasswordHash;

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

        Name name = Name.of(request.name());

        Email email = Email.of(request.email());

        Password password = Password.of(request.password());

        PasswordHash hashedPassword = PasswordHash.of(passwordHasher.hash(password.value()));

        User user = new User (

            name, 

            email,

            hashedPassword
            
        );

        repository.save(user);
        
    }
}
