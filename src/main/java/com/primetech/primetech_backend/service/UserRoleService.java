package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    void register(User user);
    void updateRole(String email);
}
