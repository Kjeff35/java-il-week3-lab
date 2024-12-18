package com.example.order_service.dtos;


import com.example.order_service.models.OrderItem;

import java.util.List;

public record OrderRequest(List<OrderItem> items) {

}
