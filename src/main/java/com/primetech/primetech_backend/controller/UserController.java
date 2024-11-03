package com.primetech.primetech_backend.controller;

import com.primetech.primetech_backend.dto.LoginDto;
import com.primetech.primetech_backend.dto.UserCreateDTO;
import com.primetech.primetech_backend.dto.UserResponseDTO;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Create new User",
            description = "Create a new User",
            responses = {
                    @ApiResponse(responseCode = "201", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))
                    })
            }
    )
    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public UserResponseDTO save(@RequestBody UserCreateDTO user) {
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
