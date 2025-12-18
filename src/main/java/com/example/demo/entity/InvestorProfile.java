package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InvestorProfile{

    @Id
    @GeneratedType
    private Long id;
    private String investorId;
    private String fullName;
    private String email;
    private boolean active;
    private Date created;



}