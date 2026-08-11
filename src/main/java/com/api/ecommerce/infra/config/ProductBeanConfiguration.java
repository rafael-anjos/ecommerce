package com.api.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.ecommerce.core.application.usecase.product.AddStockUseCase;
import com.api.ecommerce.core.application.usecase.product.CreateProductUseCase;
import com.api.ecommerce.core.application.usecase.product.DeleteProductUseCase;
import com.api.ecommerce.core.application.usecase.product.GetProductByIdUseCase;
import com.api.ecommerce.core.application.usecase.product.RemoveStockUseCase;
import com.api.ecommerce.core.application.usecase.product.UpdateProductUseCase;
import com.api.ecommerce.core.domain.repository.ProductRepository;
import com.api.ecommerce.infra.persistence.repository.product.JpaProductRepositoryAdapter;
import com.api.ecommerce.infra.persistence.repository.product.SpringDataProductRepository;

@Configuration
public class ProductBeanConfiguration {
    
    @Bean
    public ProductRepository productRepository ( SpringDataProductRepository repository ) {

        return new JpaProductRepositoryAdapter(repository);

    }

    @Bean
    public UpdateProductUseCase updateProduct ( ProductRepository repository ) {

        return new UpdateProductUseCase(repository);

    }
    
    @Bean
    public AddStockUseCase addStock ( ProductRepository repository ) {

        return new AddStockUseCase(repository);

    }

    @Bean
    public RemoveStockUseCase removeStock ( ProductRepository repository ) {

        return new RemoveStockUseCase(repository);

    }

    @Bean
    public GetProductByIdUseCase getProduct ( ProductRepository repository ) {

        return new GetProductByIdUseCase(repository);

    }

    @Bean
    public DeleteProductUseCase deleteProduct ( ProductRepository repository ) {

        return new DeleteProductUseCase(repository);

    }

    @Bean
    public CreateProductUseCase createProduct ( ProductRepository repository ) {

        return new CreateProductUseCase(repository);

    }

}
