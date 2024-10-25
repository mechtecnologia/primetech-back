package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.repository.UserRepository;
import com.primetech.primetech_backend.util.Codificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
         user.setPassword( Codificar.generateHash(user.getPassword()));
        return userRepository.save(user);
    }
}
