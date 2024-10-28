package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    User save(User user);
    List<User> findAll();
    User login(LoginDto loginDto);
}
