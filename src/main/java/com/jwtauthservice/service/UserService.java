package com.jwtauthservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwtauthservice.model.User;
import com.jwtauthservice.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setUsername(updatedUser.getUsername());
        user.setRole(updatedUser.getRole());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void changeUserRole(Long id, String newRole) {
        User user = getUserById(id);
        user.setRole(newRole);
        userRepository.save(user);
    }
}
