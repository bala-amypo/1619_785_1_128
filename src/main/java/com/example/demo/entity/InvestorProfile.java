package com.example.demo.entity;

import jakarta.persistence.Entity;


@Entity
public class InvestorProfile{

    @Id
    private Long id;
    private String investorId;
    private String fullName;
    private String email;
    private boolean active;
    private Date created;



}