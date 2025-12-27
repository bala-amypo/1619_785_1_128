package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(UserAccount userAccount);  // return AuthResponse
    AuthResponse login(AuthRequest request);
}
