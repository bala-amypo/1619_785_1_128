package com.example.demo.service.impl;

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

        // Assign default role
        userAccount.setRole(RoleType.USER.name());

        // Save user
        UserAccount savedUser = userAccountRepository.save(userAccount);

        // Return AuthResponse
        return new AuthResponse(
                savedUser.getEmail(),
                "Registration successful",
                savedUser.getRole()
        );
    }

    @Override
    public AuthResponse login(UserAccount userAccount) {
        // Here you can implement login logic (validate password, etc.)
        // Returning dummy response for compilation
        return new AuthResponse(userAccount.getEmail(), "Login successful", userAccount.getRole());
    }
}
