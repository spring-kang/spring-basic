package com.hackers.mycommerce.policy;

import com.hackers.mycommerce.user.model.AgeType;
import com.hackers.mycommerce.user.model.User;

//@Primary
//@Qualifier("defaultDiscountPolicy")
//@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private long discountPercent = 20;
    @Override
    public long discount(User user, long price) {
        if(user.getAgeType() == AgeType.MINOR) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
