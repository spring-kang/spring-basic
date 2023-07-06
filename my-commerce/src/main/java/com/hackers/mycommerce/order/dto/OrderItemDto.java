package com.hackers.mycommerce.order.dto;

import com.hackers.mycommerce.order.model.OrderItem;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderItemDto {
    private String productName;
    private long count;
    private long orderPrice;

    public static OrderItemDto from(OrderItem orderItem) {
        return OrderItemDto.builder()
                .orderPrice(orderItem.getOrderPrice())
                .count(orderItem.getCount())
                .productName(orderItem.getProduct().getName())
                .build();
    }
}
