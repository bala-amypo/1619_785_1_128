package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserAccountRepository {

    private final Map<String, UserAccount> store = new HashMap<>();

    public UserAccount save(UserAccount user) {
        store.put(user.getUsername(), user);
        return user;
    }

    public Optional<UserAccount> findByUsername(String username) {
        return Optional.ofNullable(store.get(username));
    }
}
