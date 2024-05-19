package com.cashrich.inter.dev.cryptoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.cashrich.inter.dev.cryptoapp.entity.User;
import com.cashrich.inter.dev.cryptoapp.model.LoginRequest;
import com.cashrich.inter.dev.cryptoapp.model.RegisterRequest;
import com.cashrich.inter.dev.cryptoapp.model.UpdateRequest;
import com.cashrich.inter.dev.cryptoapp.service.JwtService;
import com.cashrich.inter.dev.cryptoapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        final UserDetails userDetails = jwtService.loadUserByUsername(request.getUsername());
        final String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody UpdateRequest request) {
        User updatedUser = userService.update(request);
        return ResponseEntity.ok(updatedUser);
    }
}
