package com.hackers.mycommerce.hello;

import com.hackers.mycommerce.policy.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {
//    @Qualifier("defaultDiscountPolicy")
//    private final DiscountPolicy discountPolicy;
//
//    public int discount(Student student, int price) {
//        return discountPolicy.discount(student, price);
//    }
}
