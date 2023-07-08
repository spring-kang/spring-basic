package com.hackers.mycommerce.order.service;

import com.hackers.mycommerce.order.dto.OrderRequest;
import com.hackers.mycommerce.order.dto.OrderResponse;

public interface OrderService {
    Long createOrder(OrderRequest request);
    Long cancelOrder(Long orderId);
    OrderResponse getOrderDetails(Long orderId);

}
