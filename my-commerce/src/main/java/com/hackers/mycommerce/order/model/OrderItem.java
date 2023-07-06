package com.hackers.mycommerce.order.model;

import com.hackers.mycommerce.product.model.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private long orderPrice;
    private long count;

    public static OrderItem createOrderItem(Product product, long orderPrice, long
            count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        product.decrease(count);
        return orderItem;
    }

    public void cancel() {
        getProduct().increase(count);
    }

    public long getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}