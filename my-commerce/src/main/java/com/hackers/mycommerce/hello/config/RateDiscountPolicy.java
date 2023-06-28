package com.hackers.mycommerce.hello.config;

import com.hackers.mycommerce.hello.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Qualifier("defaultDiscountPolicy")
@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 20;
    @Override
    public int discount(Student student, int price) {
        if(!student.getIsAdult()) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
