package com.primetech.primetech_backend.controller;

import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }


}
