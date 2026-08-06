package com.api.ecommerce.infra.persistence.mapper;

import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.valueobject.Email;
import com.api.ecommerce.core.domain.valueobject.Name;
import com.api.ecommerce.core.domain.valueobject.PasswordHash;
import com.api.ecommerce.core.domain.valueobject.UserId;
import com.api.ecommerce.infra.persistence.entity.UserEntity;

public class UserMapper {
    
    public static UserEntity toEntity ( User user ) {

        return new UserEntity (
            user.getId().value(),
            user.getName().value(),
            user.getEmail().value(),
            user.getPassword().value()
        );

    }

    public static User toDomain ( UserEntity entity ) {

        return User.restore(
            UserId.of(entity.getId()), 
            Name.of(entity.getName()), 
            Email.of(entity.getEmail()),
            PasswordHash.of(entity.getPassword())
        );

    }
}
