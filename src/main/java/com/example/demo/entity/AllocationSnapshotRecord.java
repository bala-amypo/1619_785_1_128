package com.example.demo.entity;

import java.time.LocalDateTime;

public class AllocationSnapshotRecord {
    private Long id;
    private Long investorId;
    private LocalDateTime snapshotDate;
    private double totalPortfolioValue;
    private String allocationsJson;

    public AllocationSnapshotRecord(Long investorId, LocalDateTime snapshotDate, double totalPortfolioValue, String allocationsJson) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.allocationsJson = allocationsJson;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public double getTotalPortfolioValue() { return totalPortfolioValue; }
}
