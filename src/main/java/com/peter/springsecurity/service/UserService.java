package com.peter.springsecurity.service;


import com.peter.springsecurity.entity.Users;
import com.peter.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    public Users register(Users users){
       users.setPassword(encoder.encode(users.getPassword()));
        return userRepo.save(users);
    }

    public String  verify(Users users) {
        Authentication authentication =
                authmanager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(users.getUsername());

        return "Fail";
    }
}
