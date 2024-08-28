package com.peter.springsecurity.controller;


import com.peter.springsecurity.entity.Users;
import com.peter.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return userService.register(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return userService.verify(users);
    }
}
