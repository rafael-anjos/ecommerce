package com.api.ecommerce.infra.persistence.repository.cart;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.cart.CartStatus;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.user.UserId;
import com.api.ecommerce.infra.persistence.entity.CartEntity;
import com.api.ecommerce.infra.persistence.mapper.CartMapper;

public class JpaCartRepositoryAdapter implements CartRepository {
    
    private final SpringDataCartRepository repository;
    private final SpringDataCartItemRepository cartItemRepository;
    private final CartMapper mapper;

    public JpaCartRepositoryAdapter ( SpringDataCartRepository repository, SpringDataCartItemRepository cartItemRepository, CartMapper mapper ) {
        this.repository = repository;
        this.cartItemRepository = cartItemRepository;
        this.mapper = mapper;
    }

    public Cart save ( Cart cart ) {

        CartEntity entity = mapper.toEntity(cart);
        
        CartEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
        
    }

    public Optional<Cart> findById ( CartId id ) {

        return repository.findById(id.value()).map(mapper::toDomain);

    }

    public Optional<Cart> findActiveByUserId ( UserId userId ) {

        return repository.findByUserIdAndStatus(userId.value(), CartStatus.ACTIVE)
        .map(mapper::toDomain);

    }

    public boolean existsByUserId ( UserId userId ) {

        return repository.existsByUserId(userId.value());
        
    }

    @Transactional
    public void removeItem ( CartId cartId, ProductId productId ) {

        cartItemRepository.deleteByCartIdAndProductId(
            cartId.value(), 
            productId.value());

    }


}
