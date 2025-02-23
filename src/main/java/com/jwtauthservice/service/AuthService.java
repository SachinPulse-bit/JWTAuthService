package com.jwtauthservice.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtauthservice.model.User;
import com.jwtauthservice.repository.UserRepository;
import com.jwtauthservice.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // ✅ Register a new user
    public String registerUser(String username, String password, String role) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "User already exists!";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Hash password
        user.setRole(role);
        userRepository.save(user);
        return "User registered successfully!";
    }

    // ✅ Authenticate user and return JWT token with role
    public String authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty() || !passwordEncoder.matches(password, userOptional.get().getPassword())) {
            return "Invalid credentials!";
        }

        User user = userOptional.get();
        return jwtUtil.generateToken(user.getUsername(), user.getRole()); // Include role
    }
}
