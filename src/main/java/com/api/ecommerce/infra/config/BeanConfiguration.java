package com.api.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.ecommerce.core.application.usecase.CreateUserUseCase;
import com.api.ecommerce.core.application.usecase.DeleteUserUseCase;
import com.api.ecommerce.core.application.usecase.GetUserByEmailUseCase;
import com.api.ecommerce.core.application.usecase.UpdateUserUseCase;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.security.PasswordHasher;
import com.api.ecommerce.infra.persistence.repository.JpaUserRepositoryAdapter;
import com.api.ecommerce.infra.persistence.repository.SpringDataUserRepository;
import com.api.ecommerce.infra.persistence.security.password.ArgonPasswordHasher;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public CreateUserUseCase createUserUseCase ( UserRepository repository, PasswordHasher hasher ) {

        return new CreateUserUseCase(repository, hasher);

    }
    
    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase ( UserRepository repository ) {

        return new GetUserByEmailUseCase(repository);

    }

    @Bean
    public UpdateUserUseCase updateUserUseCase ( UserRepository repository ) {

        return new UpdateUserUseCase(repository);

    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase ( UserRepository repository ) {

        return new DeleteUserUseCase(repository);

    }

    @Bean
    public PasswordEncoder passwordEncoder () {

        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    }

    @Bean
    public PasswordHasher hasher ( PasswordEncoder passwordEncoder ) {

        return new ArgonPasswordHasher(passwordEncoder);

    }

    @Bean
    public UserRepository userRepository ( SpringDataUserRepository repository ) {

        return new JpaUserRepositoryAdapter(repository);

    }
}
