package com.example.product_service.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String name;
    private double price;
}
