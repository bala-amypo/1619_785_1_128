package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import java.time.LocalDateTime;

public class HoldingRecord {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private double currentValue;
    private LocalDateTime recordDate;

    public HoldingRecord(Long investorId, AssetClassType assetClass, double currentValue, LocalDateTime recordDate) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.recordDate = recordDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public double getCurrentValue() { return currentValue; }
    public LocalDateTime getRecordDate() { return recordDate; }
}
