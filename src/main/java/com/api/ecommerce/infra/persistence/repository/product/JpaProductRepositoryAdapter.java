package com.api.ecommerce.infra.persistence.repository.product;

import java.util.Optional;
import java.util.UUID;

import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.repository.ProductRepository;
import com.api.ecommerce.infra.persistence.entity.ProductEntity;
import com.api.ecommerce.infra.persistence.mapper.ProductMapper;

public class JpaProductRepositoryAdapter implements ProductRepository {

    private final SpringDataProductRepository repository;

    public JpaProductRepositoryAdapter ( SpringDataProductRepository repository ) {
        this.repository = repository;
    }

    public Product save ( Product product ) {

        ProductEntity entity = ProductMapper.toEntity(product);

        ProductEntity saved = repository.save(entity);

        return ProductMapper.toDomain(saved);

    }

    public void delete ( UUID id ) {

        repository.deleteById(id);

    }

    public Optional<Product> findById ( UUID id ) {

        return repository.findById(id).map(ProductMapper::toDomain);

    }
    
}
