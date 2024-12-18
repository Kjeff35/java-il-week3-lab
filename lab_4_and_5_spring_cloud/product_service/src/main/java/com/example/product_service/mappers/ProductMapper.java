package com.example.product_service.mappers;

import com.example.product_service.dtos.ProductRequest;
import com.example.product_service.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .price(productRequest.getPrice())
                .name(productRequest.getName())
                .build();
    }
}
