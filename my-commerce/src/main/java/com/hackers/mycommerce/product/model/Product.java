package com.hackers.mycommerce.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id @GeneratedValue
    @Column(name= "product_id")
    private Long id;

    private String name;
    private long price;
    private String desc;
    private long stock;
    private String category;
    public void increase(long quantity) {
        this.stock += quantity;
    }
    public void decrease(long quantity) {
        long restStock = this.stock - quantity;
        if (restStock < 0) {
            throw new RuntimeException("need more stock");
        }
        this.stock = restStock;
    }
}

