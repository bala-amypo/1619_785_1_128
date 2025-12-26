package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestorProfile {

    private Long id;
    private String investorId;
    private String name;
    private boolean active;
}
