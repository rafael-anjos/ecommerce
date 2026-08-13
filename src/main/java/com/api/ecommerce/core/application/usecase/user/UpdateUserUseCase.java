package com.api.ecommerce.core.application.usecase.user;

import java.util.UUID;

import com.api.ecommerce.core.application.dto.request.user.UpdateUserRequest;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.valueobject.user.Email;
import com.api.ecommerce.core.domain.valueobject.user.UserName;

public class UpdateUserUseCase {
    
    private final UserRepository repository;

    public UpdateUserUseCase ( UserRepository repository ) {
        this.repository = repository;
    }

    public void execute ( UUID id, UpdateUserRequest request ) {

        User user = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());

        UserName name = UserName.of(request.name());

        Email email = Email.of(request.email());

        user.changeName(name);
        
        user.changeEmail(email);

        repository.save(user);    

    }
}
