package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount user) {
        return authService.login(user);
    }
}
