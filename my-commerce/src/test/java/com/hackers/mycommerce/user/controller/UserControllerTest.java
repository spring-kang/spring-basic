package com.hackers.mycommerce.user.controller;

import com.hackers.mycommerce.user.dto.UserResponse;
import com.hackers.mycommerce.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean
    UserServiceImpl userService;

    @Test
    void getUserTest() throws Exception {

        Long userId = 1L;

        given(userService.getUser(userId)).willReturn(UserResponse.builder().name("kang").email("hackers@hackers.com").address("seoul").phoneNumber("0101234567").build());

        mockMvc.perform(
                            get("/api/users/"+userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("hackers@hackers.com"))
                .andExpect(jsonPath("$.phoneNumber").value("0101234567"))
                .andDo(print());
        verify(userService).getUser(userId);
    }

    @Test
    void deleteUserTest() throws Exception {

        Long userId = 1L;

        given(userService.removeUser(userId)).willReturn(userId);

        mockMvc.perform(
                        delete("/api/users/"+userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andDo(print());
        verify(userService).removeUser(userId);
    }

}