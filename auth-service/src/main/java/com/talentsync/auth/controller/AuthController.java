package com.talentsync.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentsync.auth.dto.LoginResponse;
import com.talentsync.auth.entity.User;
import com.talentsync.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {

        String token = service.login(user.getEmail(), user.getPassword());

        if (token == null) {
            return null;
        }

        User loggedUser = service.getUser(user.getEmail());

        return new LoginResponse(
            token,
            loggedUser.getName(),
            loggedUser.getEmail(),
            loggedUser.getRole()
        );
    }
    
    @GetMapping("/profile")
    public String profile() {
        return "JWT authentication successful";
    }
    
}