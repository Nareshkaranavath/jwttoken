package com.jwttoken.service;

import com.jwttoken.entity.CustomUser;
import com.jwttoken.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService {
    private final UserRepo userRepo;
 private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomUserService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public CustomUser register(CustomUser user) {
        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        return userRepo.save(user);
    }
}
