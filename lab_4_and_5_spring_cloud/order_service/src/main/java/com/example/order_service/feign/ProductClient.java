package com.example.order_service.feign;

import com.example.order_service.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUCT-SERVICE")
public interface ProductClient {
    @GetMapping("/api/products/{productId}")
    ResponseEntity<Product> findProductById(@PathVariable("productId") Long id);
}
