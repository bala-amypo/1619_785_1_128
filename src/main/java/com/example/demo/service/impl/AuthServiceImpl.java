package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;

    public AuthServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount register(UserAccount user) {
        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount login(UserAccount user) {
        Optional<UserAccount> optional =
                userAccountRepository.findByUsername(user.getUsername());

        return optional.orElse(null);
    }
}
