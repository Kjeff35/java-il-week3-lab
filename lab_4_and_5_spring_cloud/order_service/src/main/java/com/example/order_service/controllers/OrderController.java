package com.example.order_service.controllers;

import com.example.order_service.dtos.OrderRequest;
import com.example.order_service.models.Order;
import com.example.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request, @AuthenticationPrincipal Jwt jwt) {
        return new ResponseEntity<>(orderService.createOrder(request, jwt.getSubject()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") long orderId) {
        return ResponseEntity.ok(orderService.findOrderById(orderId));
    }

}
