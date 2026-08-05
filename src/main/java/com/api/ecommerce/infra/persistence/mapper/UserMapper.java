package com.api.ecommerce.infra.persistence.mapper;

import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.infra.persistence.entity.UserEntity;

public class UserMapper {
    
    public static UserEntity toEntity ( User user ) {

        return new UserEntity (
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword()
        );

    }

    public static User toDomain ( UserEntity entity ) {

        return User.restore(
            entity.getId(), 
            entity.getName(), 
            entity.getEmail(),
            entity.getPassword()
        );

    }
}
