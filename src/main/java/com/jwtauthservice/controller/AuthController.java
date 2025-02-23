package com.jwtauthservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauthservice.dto.AuthRequest;
import com.jwtauthservice.dto.RegisterRequest;
import com.jwtauthservice.service.AuthService;
import com.jwtauthservice.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @GetMapping("/ping")
    public String test() {
        return "PONG";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String response = authService.registerUser(request.getUsername(), request.getPassword(), request.getRole());
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        String token = authService.authenticate(request.getUsername(), request.getPassword());
        if (token.equals("Invalid credentials!")) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        return ResponseEntity.ok(token);
    }
}
