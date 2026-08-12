package com.api.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.ecommerce.core.application.usecase.cart.CreateCartUseCase;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.infra.persistence.mapper.CartItemMapper;
import com.api.ecommerce.infra.persistence.mapper.CartMapper;
import com.api.ecommerce.infra.persistence.repository.cart.JpaCartRepositoryAdapter;
import com.api.ecommerce.infra.persistence.repository.cart.SpringDataCartRepository;

@Configuration
public class CartBeanConfiguration {

    @Bean
    public CartMapper cartMapper ( CartItemMapper mapper ) {

        return new CartMapper(mapper);

    }

    @Bean
    public CartItemMapper cartItemMapper () {

        return new CartItemMapper();

    }

    @Bean
    public CartRepository cartRepository ( SpringDataCartRepository repository ) {

        return new JpaCartRepositoryAdapter(repository);

    }

    @Bean
    public CreateCartUseCase createCart ( CartRepository cartRepository, UserRepository userRepository ) {

        return new CreateCartUseCase(cartRepository, userRepository);

    }

}
