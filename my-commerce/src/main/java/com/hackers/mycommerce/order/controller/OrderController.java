package com.hackers.mycommerce.order.controller;

import com.hackers.mycommerce.order.dto.OrderRequest;
import com.hackers.mycommerce.order.dto.OrderResponse;
import com.hackers.mycommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/orders")
    public ResponseEntity<Map<String,Long>> createOrder(@RequestBody OrderRequest request) {
        Long orderId = orderService.createOrder(request);
        Map<String, Long> response = new HashMap<>();
        response.put("id", orderId);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/api/orders/{id}/cancel")
    public ResponseEntity<Map<String,Long>> cancelOrder(@PathVariable("id") Long id) {
        Long orderId = orderService.cancelOrder(id);
        Map<String, Long> response = new HashMap<>();
        response.put("id", orderId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("id") Long id) {
        OrderResponse response = orderService.getOrderDetails(id);
        return ResponseEntity.ok(response);
    }
}