package com.example.product_service.services.impl;

import com.example.product_service.dtos.ProductRequest;
import com.example.product_service.mappers.ProductMapper;
import com.example.product_service.models.Product;
import com.example.product_service.repositories.ProductRepository;
import com.example.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(productMapper.toProduct(productRequest));
    }
}
