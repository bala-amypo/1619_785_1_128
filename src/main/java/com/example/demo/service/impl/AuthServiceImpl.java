package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.UserAccount;  
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public AuthResponse authenticate(AuthRequest request) {  // <-- make sure return type is here
        UserAccount user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new RuntimeException("User not found"));


        // generate JWT
        String token = jwtUtil.generateToken(user.getEmail());

        // return AuthResponse
        return new AuthResponse(token, user.getEmail(), user.getRole());
    }
}
