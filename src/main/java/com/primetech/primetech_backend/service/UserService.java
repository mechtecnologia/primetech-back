package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.dto.UserCreateDTO;
import com.primetech.primetech_backend.dto.UserResponseDTO;
import com.primetech.primetech_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    UserResponseDTO save(UserCreateDTO user);
    List<UserResponseDTO> findAll();
    User authenticate(LoginDto loginDto);
}
