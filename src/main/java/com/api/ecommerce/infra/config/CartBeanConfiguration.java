package com.api.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.ecommerce.core.application.usecase.cart.AddItemToCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.CreateCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.GetCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.RemoveItemToCartUseCase;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.repository.ProductRepository;
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
    public CartRepository cartRepository ( SpringDataCartRepository repository, CartMapper mapper ) {

        return new JpaCartRepositoryAdapter(repository, mapper);

    }

    @Bean
    public CreateCartUseCase createCart ( CartRepository cartRepository ) {

        return new CreateCartUseCase ( cartRepository );

    }

    @Bean
    public GetCartUseCase getCart ( CartRepository cartRepository ) {

        return new GetCartUseCase(cartRepository);

    }

    @Bean
    public AddItemToCartUseCase addItemToCart ( CartRepository repository, ProductRepository productRepository ) {

        return new AddItemToCartUseCase(repository, productRepository);

    }

    @Bean
    public RemoveItemToCartUseCase removeItemToCart ( CartRepository repository ) {

        return new RemoveItemToCartUseCase(repository);

    }

}
