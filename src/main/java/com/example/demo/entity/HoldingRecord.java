package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.entity.enums.AssetClassType;

import jakarta.persistence.*;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private double value;

    private LocalDateTime timestamp;

    // REQUIRED by JPA
    public HoldingRecord() {}

    // REQUIRED by TEST
    public HoldingRecord(Long investorId,
                         AssetClassType assetClass,
                         double value,
                         LocalDateTime timestamp) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.value = value;
        this.timestamp = timestamp;
    }

    // getters & setters
    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public double getValue() { return value; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setId(Long id) { this.id = id; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }
    public void setValue(double value) { this.value = value; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
