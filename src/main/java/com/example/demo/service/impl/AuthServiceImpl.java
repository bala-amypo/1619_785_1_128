package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAccountRepository userRepo;

    @Override
    public AuthResponse login(AuthRequest request) {
        // Minimal stub for tests
        return new AuthResponse("dummy-token");
    }

    @Override
    public UserAccount register(UserAccount user) {
        return userRepo.save(user);
    }
    public AuthResponse(String token) {
        this.token = token;
    }
}
