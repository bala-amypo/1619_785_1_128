package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;  // <-- MUST EXIST

    private String holdingData;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getHoldingData() {
        return holdingData;
    }

    public void setHoldingData(String holdingData) {
        this.holdingData = holdingData;
    }
}
