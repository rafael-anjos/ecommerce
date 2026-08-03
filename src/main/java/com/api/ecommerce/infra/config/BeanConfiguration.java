package com.api.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.ecommerce.core.application.usecase.CreateUserUseCase;
import com.api.ecommerce.core.application.usecase.GetUserByEmailUseCase;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.infra.persistence.repository.JpaUserRepositoryAdapter;
import com.api.ecommerce.infra.persistence.repository.SpringDataUserRepository;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public CreateUserUseCase createUserUseCase ( UserRepository repository) {

        return new CreateUserUseCase(repository);

    }
    
    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase ( UserRepository repository ) {

        return new GetUserByEmailUseCase(repository);

    }

    @Bean
    public UserRepository userRepository ( SpringDataUserRepository repository ) {

        return new JpaUserRepositoryAdapter(repository);

    }
}
