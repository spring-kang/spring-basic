package com.hackers.mycommerce.user.controller;

import com.hackers.mycommerce.user.dto.UserRequest;
import com.hackers.mycommerce.user.dto.UserResponse;
import com.hackers.mycommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> joinUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userService.joinUser(userRequest));
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userService.updateUser(id, userRequest));
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Map<String, Long>> removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        Map<String, Long> response = new HashMap<>();
        response.put("id", id);
        return ResponseEntity.ok().body(response);
    }
}
