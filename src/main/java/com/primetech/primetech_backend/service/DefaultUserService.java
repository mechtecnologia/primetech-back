package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.dto.UserCreateDTO;
import com.primetech.primetech_backend.dto.UserResponseDTO;
import com.primetech.primetech_backend.entity.Role;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.exception.ApplicationException;
import com.primetech.primetech_backend.repository.UserRepository;
import com.primetech.primetech_backend.util.Codificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO save(UserCreateDTO userCreateDTO) {

        User emailUser = userRepository.findByEmail(userCreateDTO.getEmail());

        if (emailUser != null) {
            throw new ApplicationException("Email já cadastrado");
        }
        User user =convertToUser(userCreateDTO);
        user.setPassword(Codificar.generateHash(user.getPassword()));
        userRepository.save(user);


        UserResponseDTO userResponseDTO = getUserResponseDTO(user);
        return userResponseDTO;
    }


    @Override
    public List<UserResponseDTO> findAll() {
        List<User> lista= userRepository.findAll();
        return lista.stream().map(this::getUserResponseDTO).collect(Collectors.toList());
    }

    @Override
    public User authenticate(LoginDto loginDto) {
        User emailUser = userRepository.findByEmail(loginDto.getEmail());

        if (emailUser != null) {
            loginDto.setPassword(Codificar.generateHash(loginDto.getPassword()));
            if (emailUser.getPassword().equals(loginDto.getPassword())) {
                return emailUser;
            }
        }
        throw new ApplicationException("Credenciais invalidas");
    }


    private User convertToUser(UserCreateDTO userCreateDTO){
        User user= new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setEmail(userCreateDTO.getEmail());
        user.setPassword(userCreateDTO.getPassword());
        return  user;
    }

    private  UserResponseDTO getUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        if (user.getRoles()!=null){
            List<String> roles = user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toList());
            userResponseDTO.setRoles(roles);
        }



        return userResponseDTO;
    }

}
