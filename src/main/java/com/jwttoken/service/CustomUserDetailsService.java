package com.jwttoken.service;

import com.jwttoken.entity.CustomUser;
import com.jwttoken.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to find user: " + username);
        if (username == null || username.isEmpty()) {
            System.out.println("Username is null or empty");
            throw new UsernameNotFoundException("Username is null or empty");
        }
        CustomUser user = userRepo.findByUserName(username);
        if (user == null) {
            System.out.println("User is not available");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

}
