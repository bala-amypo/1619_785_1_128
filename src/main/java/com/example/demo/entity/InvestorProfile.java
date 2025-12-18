package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.GeneratedValue;

@Entity
public class InvestorProfile{

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String investorId;
    private String fullName;
    private String email;
    private boolean active;
    private Date created;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getInvestorId(){return investorId;}
    public void setInvestorId(String investorId){this.}
}