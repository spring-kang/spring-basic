package com.hackers.mycommerce.user.service;

import com.hackers.mycommerce.security.token.JwtProvider;
import com.hackers.mycommerce.user.dto.LoginRequest;
import com.hackers.mycommerce.user.dto.UserRequest;
import com.hackers.mycommerce.user.dto.UserResponse;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.model.UserRole;
import com.hackers.mycommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse joinUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEncPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setAgeType(userRequest.getAgeType());

        user.setRoles(Collections.singletonList(UserRole.builder().user(user).name("ROLE_USER").build()));

        userRepository.save(user);

        return UserResponse.from(user);
    }

    @Override
    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new BadCredentialsException("Invalid Email info"));

        if(!passwordEncoder.matches(request.getPassword(), user.getEncPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return UserResponse.from(user, jwtProvider.createToken(user.getEmail(), user.getRoles()));
    }

    @Override
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
        user.setAgeType(userRequest.getAgeType());

        //userRepository.save(user);

        return UserResponse.from(user);
    }

    @Override
    public UserResponse getUser(long id) {
        Optional<User> findUser = userRepository.findById(id);

        if (!findUser.isPresent()) {
            throw new RuntimeException("User not found");
        }

        return UserResponse.from(findUser.get());
    }

    @Override
    public Long removeUser(long id) {
        userRepository.deleteById(id);

        return id;
    }

}
