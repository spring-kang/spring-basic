package com.hackers.mycommerce.user.service;

import com.hackers.mycommerce.user.dto.UserRequest;
import com.hackers.mycommerce.user.dto.UserResponse;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    @MockBean
    UserRepository userRepository;
    @Autowired
    UserServiceImpl userService;

    @Test
    public void joinUserTest() {
        User user = new User();
        user.setId(1L);
        user.setName("kang");
        user.setAddress("seoul");
        user.setEmail("abcd@hackers.com");
        user.setPhoneNumber("0101234567");
        user.setEncPassword("12345");

        UserRequest userRequest = UserRequest.builder()
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .password("12345")
                .build();

        when(userRepository.save(user)).thenReturn(user);

        UserResponse userResponse = userService.joinUser(userRequest);

        Assertions.assertEquals(user.getName(), userResponse.getName());
        Assertions.assertEquals(user.getEmail(), userResponse.getEmail());
        Assertions.assertEquals(user.getPhoneNumber(), userResponse.getPhoneNumber());
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId(1L);
        user.setName("kang");
        user.setAddress("seoul");
        user.setEmail("abcd@hackers.com");
        user.setPhoneNumber("0101234567");
        user.setEncPassword("12345");

        UserRequest userRequest = UserRequest.builder()
                .name(user.getName())
                .address("seongnam")
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .password("12345")
                .build();

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        UserResponse userResponse = userService.updateUser(user.getId(), userRequest);

        Assertions.assertEquals(userRequest.getAddress(), userResponse.getAddress());
    }
}