package com.api.ecommerce.core.application.usecase;

import com.api.ecommerce.core.application.dto.response.GetUserResponse;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.EmailNotFoundException;
import com.api.ecommerce.core.domain.repository.UserRepository;

public class GetUserByEmailUseCase {

    private final UserRepository repository;

    public GetUserByEmailUseCase ( UserRepository repository ) {
        this.repository = repository;
    }

    public GetUserResponse execute ( String email ) {

        if (!repository.existsByEmail(email)) {
            throw new EmailNotFoundException(email);
        }

        User user = repository.findByEmail(email);

        return new GetUserResponse(

            user.getId(),

            user.getName(),

            user.getEmail()
            
        );

    }
    
}
