package com.springboot.quizapp.controller;

import com.springboot.quizapp.entity.User;
import com.springboot.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

//    private JwtService jwtService;
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) throws Exception{
        return userService.authenticateUser(user);
    }

    @PostMapping("/register")
    public int registerUser(@RequestBody User user) throws Exception{
        return userService.registerUser(user);
    }
}
