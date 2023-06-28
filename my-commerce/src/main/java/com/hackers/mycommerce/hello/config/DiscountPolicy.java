package com.hackers.mycommerce.hello.config;

import com.hackers.mycommerce.hello.Student;

public interface DiscountPolicy {
    int discount(Student student, int price);
}
