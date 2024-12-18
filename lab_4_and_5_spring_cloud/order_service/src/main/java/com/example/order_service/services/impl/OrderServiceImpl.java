package com.example.order_service.services.impl;

import com.example.order_service.dtos.OrderRequest;
import com.example.order_service.models.Order;
import com.example.order_service.models.OrderItem;
import com.example.order_service.repositories.OrderItemRepository;
import com.example.order_service.repositories.OrderRepository;
import com.example.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(OrderRequest request, String customerId) {
        List<OrderItem> orderItems = request.items().stream()
                .map(requestItem -> {
                    OrderItem orderItem = OrderItem.builder().quantity(requestItem.getQuantity()).productId(requestItem.getProductId()).build();
                    return orderItemRepository.save(orderItem);
                })
                .toList();

        Order order = Order.builder().customerId(customerId).items(orderItems).build();
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
