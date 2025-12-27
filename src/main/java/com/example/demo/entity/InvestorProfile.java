package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;     // must match repository
    private boolean active;      // add this

    // getters & setters
    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
