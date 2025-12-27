package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;

    public AuthServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public AuthResponse register(UserAccount userAccount) {
        userAccount.setRole(RoleType.USER.name());  // convert enum to String
        UserAccount saved = userAccountRepository.save(userAccount);
        return new AuthResponse(saved.getEmail(), "User registered", saved.getRole());
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        UserAccount user = userAccountRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new AuthResponse(user.getEmail(), "Login successful", user.getRole());
    }
}
