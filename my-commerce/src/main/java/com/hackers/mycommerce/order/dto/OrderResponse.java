package com.hackers.mycommerce.order.dto;

import com.hackers.mycommerce.order.model.Order;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class OrderResponse {
    private long userId;
    private long orderId;
    private List<OrderItemDto> orderItems;
    private String orderStatus;
    private LocalDateTime orderDate;
    private long totalPrice;

    public static OrderResponse from(Order order) {
        return OrderResponse.builder()
                .userId(order.getUser().getId())
                .orderId(order.getId())
                .orderItems(order.getOrderItems().stream().map(
                        OrderItemDto::from
                ).toList())
                .orderStatus(order.getOrderStatus())
                .orderDate(order.getOrderDate())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
