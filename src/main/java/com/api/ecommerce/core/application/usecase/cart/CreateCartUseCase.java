package com.api.ecommerce.core.application.usecase.cart;

import java.util.UUID;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.UserNotFoundException;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.repository.UserRepository;

public class CreateCartUseCase {
    
    private final CartRepository repository;
    private final UserRepository userRepository;

    public CreateCartUseCase ( CartRepository repository, UserRepository userRepository ) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void execute ( UUID userId ) {

        User user = userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException());

        Cart cart = new Cart(user.getId());

        repository.save(cart);

    }
    
}
