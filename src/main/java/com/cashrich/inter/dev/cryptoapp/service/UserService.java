package com.cashrich.inter.dev.cryptoapp.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cashrich.inter.dev.cryptoapp.entity.User;
import com.cashrich.inter.dev.cryptoapp.model.RegisterRequest;
import com.cashrich.inter.dev.cryptoapp.model.UpdateRequest;
import com.cashrich.inter.dev.cryptoapp.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername()) || userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Username or email already exists");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public User update(UpdateRequest request) {
        User existingUser = userRepository.findById(request.getId())
                                          .orElseThrow(() -> new RuntimeException("User not found")); // You might want to handle this exception more gracefully

        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setEmail(request.getEmail());
        existingUser.setMobile(request.getMobile());

        return userRepository.save(existingUser);
    }
}
