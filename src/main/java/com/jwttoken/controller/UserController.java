package com.jwttoken.controller;

import com.jwttoken.entity.UserDetails;
import com.jwttoken.repository.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @PostMapping("/register")
    public UserDetails register(@RequestBody UserDetails user){
        UserDetails  saveUser = userRepo.save(user);
        return saveUser;
    }
    @PostMapping("/login")
    public String login(@RequestBody UserDetails  userLogin){
        UserDetails userLog = userRepo.findByUserName(userLogin.getUserName());
      if(userLog !=null && userLog.getUserName().equals(userLogin.getUserName())){
          return "login successfully";
      }
      return "Login failed ";
    }
}
