package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.entity.enums.RoleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    private Long id;
    private String username;
    private String password;
    private RoleType role;
    private boolean enabled;
}
