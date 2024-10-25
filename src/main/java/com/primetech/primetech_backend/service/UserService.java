package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    User save(User user);
}
