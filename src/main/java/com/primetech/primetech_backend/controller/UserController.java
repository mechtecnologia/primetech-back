package com.primetech.primetech_backend.controller;

import com.primetech.primetech_backend.config.security.TokenAuthenticator;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public List<UserResponseDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody LoginDto loginTo){

        User user = userService.authenticate(loginTo);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user,user.getPassword(), user.getAuthorities());
        token.setDetails(user);
        String tokenStr = TokenAuthenticator.addAuthentication(token);
        return ResponseEntity.ok().header(TokenAuthenticator.HEADER_STRING,tokenStr).body("sucesfful");
    }


}
