package com.hackers.mycommerce.policy;

import com.hackers.mycommerce.hello.Student;
import com.hackers.mycommerce.user.model.User;

public interface DiscountPolicy {
    long discount(User user, long price);
}
