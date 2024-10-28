package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.exception.ApplicationException;
import com.primetech.primetech_backend.repository.UserRepository;
import com.primetech.primetech_backend.util.Codificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        User emailUser = userRepository.findByEmail(user.getEmail());

        if (emailUser != null) {
            throw new ApplicationException("Email já cadastrado");
        }

        user.setPassword(Codificar.generateHash(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User login(LoginDto loginDto) {
        User emailUser = userRepository.findByEmail(loginDto.getEmail());


        if (emailUser != null) {
            loginDto.setPassword(Codificar.generateHash(loginDto.getPassword()));
            if (emailUser.getPassword().equals(loginDto.getPassword())) {
                return emailUser;
            }
        }
        throw new ApplicationException("Credenciais invalidas");
    }

}
