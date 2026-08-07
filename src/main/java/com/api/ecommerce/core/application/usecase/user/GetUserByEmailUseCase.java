package com.api.ecommerce.core.application.usecase.user;

import com.api.ecommerce.core.application.dto.response.user.GetUserResponse;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.EmailNotFoundException;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.valueobject.user.Email;
import com.api.ecommerce.core.domain.valueobject.user.UserName;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

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

        UserId id = UserId.of(user.getId().value());

        UserName name = UserName.of(user.getName().value());

        Email email2 = Email.of(user.getEmail().value());

        return new GetUserResponse(

            id.value(),

            name.value(),

            email2.value()
            
        );

    }
    
}
