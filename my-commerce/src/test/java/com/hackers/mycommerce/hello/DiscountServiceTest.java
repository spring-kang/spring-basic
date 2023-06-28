package com.hackers.mycommerce.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiscountServiceTest {

    @Autowired DiscountService discountService;

    @Test
    void testDiscountPolicy() {
        Student student = new Student();
        student.setId(1L);
        student.setName("kang");
        student.setIsAdult(false);

        int price = 10000;

        int discountPrice = discountService.discount(student, price);

        Assertions.assertEquals(2000, discountPrice);
    }
}