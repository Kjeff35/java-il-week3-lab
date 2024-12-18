package com.example.product_service.controllers;

import com.example.product_service.dtos.ProductRequest;
import com.example.product_service.models.Product;
import com.example.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping()
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable("productId") Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }
}
