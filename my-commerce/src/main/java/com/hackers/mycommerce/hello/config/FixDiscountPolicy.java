package com.hackers.mycommerce.hello.config;

import com.hackers.mycommerce.hello.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class FixDiscountPolicy implements DiscountPolicy{
    private int discountPrice = 1000;
    @Override
    public int discount(Student student, int price) {
        if(!student.getIsAdult()) {
            return 1000;
        }
        return 0;
    }
}
