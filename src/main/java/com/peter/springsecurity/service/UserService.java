package com.peter.springsecurity.service;


import com.peter.springsecurity.entity.Users;
import com.peter.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    private UserRepo userRepo;
    public Users register(Users users){
       users.setPassword(encoder.encode(users.getPassword()));
        return userRepo.save(users);
    }
}
