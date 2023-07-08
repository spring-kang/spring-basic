package com.hackers.mycommerce.user.service;

import com.hackers.mycommerce.user.model.CustomUserDetails;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(
                () ->new UsernameNotFoundException("Invalid authentication")
        );
        return new CustomUserDetails(user);
    }
}
