package com.hackers.mycommerce.policy.config;

import com.hackers.mycommerce.policy.DiscountPolicy;
import com.hackers.mycommerce.policy.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PolicyConfig {
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

//    @Bean
//    public DiscountService discountService() {
//        return new DiscountService(discountPolicy());
//    }

}
