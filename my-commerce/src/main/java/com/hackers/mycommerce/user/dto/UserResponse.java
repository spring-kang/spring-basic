package com.hackers.mycommerce.user.dto;

import com.hackers.mycommerce.user.model.User;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
