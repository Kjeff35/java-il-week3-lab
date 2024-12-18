package com.example.order_service.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private double price;

}