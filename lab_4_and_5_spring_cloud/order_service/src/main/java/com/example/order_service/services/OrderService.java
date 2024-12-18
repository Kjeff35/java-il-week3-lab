package com.example.order_service.services;

import com.example.order_service.dtos.OrderRequest;
import com.example.order_service.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest request, String customerId);

    List<Order> findAllOrders();

    Order findOrderById(long orderId);
}
