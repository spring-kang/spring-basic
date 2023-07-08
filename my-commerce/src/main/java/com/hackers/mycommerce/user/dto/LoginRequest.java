package com.hackers.mycommerce.user.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
