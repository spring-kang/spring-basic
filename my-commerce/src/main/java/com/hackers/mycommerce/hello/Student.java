package com.hackers.mycommerce.hello;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    private Boolean isAdult;
}