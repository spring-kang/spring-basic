package com.hackers.mycommerce.policy;

import com.hackers.mycommerce.user.model.AgeType;
import com.hackers.mycommerce.user.model.User;


public class FixDiscountPolicy implements DiscountPolicy{
    private int discountPrice = 1000;
    @Override
    public long discount(User user, long price) {
        if(user.getAgeType() == AgeType.MINOR) {
            return 1000;
        }
        return 0;
    }
}
