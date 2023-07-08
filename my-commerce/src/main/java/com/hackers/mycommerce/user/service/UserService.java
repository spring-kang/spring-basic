package com.hackers.mycommerce.user.service;

import com.hackers.mycommerce.user.dto.LoginRequest;
import com.hackers.mycommerce.user.dto.UserRequest;
import com.hackers.mycommerce.user.dto.UserResponse;

public interface UserService {
    UserResponse joinUser(UserRequest userRequest);
    UserResponse login(LoginRequest request);
    UserResponse updateUser(long id, UserRequest userRequest);
    UserResponse getUser(long id);
    Long removeUser(long id);
}
