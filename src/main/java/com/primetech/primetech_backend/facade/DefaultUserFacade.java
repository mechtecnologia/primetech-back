package com.primetech.primetech_backend.facade;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.dto.UserCreateDTO;
import com.primetech.primetech_backend.dto.UserResponseDTO;
import com.primetech.primetech_backend.entity.Role;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.entity.UserRole;
import com.primetech.primetech_backend.service.UserRoleService;
import com.primetech.primetech_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class DefaultUserFacade implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;


    @Override
    public UserResponseDTO save(UserCreateDTO user) {
       User userSaved= userService.save(user);
       userRoleService.register(userSaved);
       return  getUserResponseDTO(userSaved);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userService.findAll();
    }

    @Override
    public User authenticate(LoginDto loginDto) {
        return userService.authenticate(loginDto);
    }

//    public void updateUser(){
//        userRoleService.updateRole(String email);
//    }

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
