package com.hackers.mycommerce.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.model.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Builder
@Value
public class UserResponse {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private List<UserRole> roles = new ArrayList<>();
    @JsonIgnore
    private String token;

    public static UserResponse from(User user) {
        UserResponse userResponse = UserResponse.builder()
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
        user.getRoles().forEach(role -> userResponse.getRoles().add(role));

        return userResponse;
    }

    public static UserResponse from(User user, String token) {
        UserResponse userResponse = UserResponse.builder()
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .token(token)
                .build();
        user.getRoles().forEach(role -> userResponse.getRoles().add(role));

        return userResponse;
    }

}
