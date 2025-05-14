package com.student.managementsystem.service;

import com.student.managementsystem.dto.UserDTO;
import com.student.managementsystem.entity.User;
import com.student.managementsystem.exception.ResourceNotFoundException;
import com.student.managementsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        User savedUser = userRepository.save(user);

        userDTO.setId(savedUser.getId());
        userDTO.setPassword(null); // Clear password for security
        return userDTO;
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public Object getAllUsers() {
        return null;
    }

    public com.student.managementsystem.entity.User registerUser(String username, String password, String role, String email) {
        return null;
    }
}