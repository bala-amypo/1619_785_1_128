package com.example.demo.entity;

import jakarta.persistence.*;
import com.example.demo.entity.enums.AssetClassType;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass; // <-- Add this field

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

    public AssetClassType getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(AssetClassType assetClass) {
        this.assetClass = assetClass;
    }

    public String getHoldingData() {
        return holdingData;
    }

    public void setHoldingData(String holdingData) {
        this.holdingData = holdingData;
    }
}
