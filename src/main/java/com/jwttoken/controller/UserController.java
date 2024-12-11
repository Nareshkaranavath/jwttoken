package com.jwttoken.controller;

import com.jwttoken.entity.CustomUser;
import com.jwttoken.repository.UserRepo;
import com.jwttoken.service.CustomUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepo userRepo;
    private final  CustomUserService customUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepo userRepo, CustomUserService customUserService,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.customUserService = customUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/register")
    public CustomUser register(@RequestBody CustomUser user) {
        //return userRepository.save(user);
        return customUserService.register(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody CustomUser userLogin) {
        // Add null checks and log the received login attempt
        if (userLogin == null || userLogin.getUserName() == null || userLogin.getPwd() == null) {
            return "User name or password is missing";
        }
        System.out.println("Attempting to find user: " + userLogin.getUserName());
        CustomUser userLog = userRepo.findByUserName(userLogin.getUserName());
        if (userLog != null && bCryptPasswordEncoder.matches(userLogin.getPwd(), userLog.getPwd())) {
            return "Login successfully";
        }
        return "Login failed";
    }

}
