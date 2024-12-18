package com.example.product_service.services;

import com.example.product_service.dtos.ProductRequest;
import com.example.product_service.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findProductById(Long id);

    Product createProduct(ProductRequest productRequest);
}
