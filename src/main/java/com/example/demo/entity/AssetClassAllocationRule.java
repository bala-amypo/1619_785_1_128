package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;

public class AssetClassAllocationRule {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private double targetPercentage;
    private boolean active;

    public AssetClassAllocationRule(Long investorId, AssetClassType assetClass, double targetPercentage, boolean active) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(double targetPercentage) { this.targetPercentage = targetPercentage; }
    public boolean isActive() { return active; }
}
