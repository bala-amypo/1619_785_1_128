package com.example.demo.entity;

import com.example.demo.entity.enums.RoleType;

public class UserAccount {
    private Long id;
    private String username;
    private String email;
    private String password;
    private RoleType role;

    public UserAccount(String username, String email, String password, RoleType role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public RoleType getRole() { return role; }
}
