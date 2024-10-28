package com.primetech.primetech_backend.controller;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/list")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDto login) {
        return userService.login(login);
    }


}
