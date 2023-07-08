package com.hackers.mycommerce.user.dto;

import com.hackers.mycommerce.user.model.AgeType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserRequest {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    private AgeType ageType;
}
