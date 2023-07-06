package com.hackers.mycommerce.order.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class OrderRequest {
    private Long userId;

    private Long productId;

    private long count;
}
