package com.hackers.mycommerce.user.service;

import com.hackers.mycommerce.user.dto.UserRequest;
import com.hackers.mycommerce.user.dto.UserResponse;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse joinUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEncPassword("enc_password");

        userRepository.save(user);

        return UserResponse.from(user);
    }

    @Transactional
    public UserResponse updateUser(long id, UserRequest userRequest) {
        Optional<User> findUser = userRepository.findById(id);

        if (!findUser.isPresent()) {
            throw new RuntimeException("User not found");
        }

        User user = findUser.get();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEncPassword("enc_password");

        //userRepository.save(user);

        return UserResponse.from(user);
    }

    public UserResponse getUser(long id) {
        Optional<User> findUser = userRepository.findById(id);

        if (!findUser.isPresent()) {
            throw new RuntimeException("User not found");
        }

        return UserResponse.from(findUser.get());
    }

    public Long removeUser(long id) {
        userRepository.deleteById(id);

        return id;
    }
}
