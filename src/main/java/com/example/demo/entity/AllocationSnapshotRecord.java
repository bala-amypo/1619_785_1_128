package com.example.demo.entity;

import java.time.LocalDateTime;

public class AllocationSnapshotRecord {

    private Long id;
    private Long investorId;
    private LocalDateTime snapshotDate;
    private Double totalPortfolioValue;
    private String detailsJson;

    public AllocationSnapshotRecord(Long investorId, LocalDateTime snapshotDate,
                                    Double totalPortfolioValue, String detailsJson) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.detailsJson = detailsJson;
    }

    public AllocationSnapshotRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInvestorId() { return investorId; }
    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public Double getTotalPortfolioValue() { return totalPortfolioValue; }
}
