package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest; // Added missing import
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(UserAccount userAccount) {
        // Encode password
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));

        // FIX: Assign Enum directly, not .name() (which is a String)
        userAccount.setRole(RoleType.USER);

        // Save user
        UserAccount savedUser = userAccountRepository.save(userAccount);

        // Return AuthResponse 
        // FIX: Use .name() here if the constructor expects a String
        return new AuthResponse(
                savedUser.getEmail(),
                "Registration successful",
                savedUser.getRole().name() 
        );
    }

    @Override
    public AuthResponse login(AuthRequest request) { 
        // Logic for authentication goes here
        return new AuthResponse(request.getEmail(), "Login successful", "");
    }
}