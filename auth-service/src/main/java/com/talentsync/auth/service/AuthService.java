package com.talentsync.auth.service;

import org.springframework.stereotype.Service;

import com.talentsync.auth.entity.User;
import com.talentsync.auth.repository.UserRepository;
import com.talentsync.auth.util.JwtUtil;

@Service
public class AuthService {

    private final UserRepository repository;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repository, JwtUtil jwtUtil) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
    }

    public User register(User user) {
        return repository.save(user);
    }

    public User getUser(String email) {
        return repository.findByEmail(email);
    }

    public String login(String email, String password) {

        User user = repository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return jwtUtil.generateToken(user.getEmail(), user.getRole());
        }

        return null;
    }
}