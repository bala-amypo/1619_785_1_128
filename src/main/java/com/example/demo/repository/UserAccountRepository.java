package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.demo.entity.UserAccount;

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
