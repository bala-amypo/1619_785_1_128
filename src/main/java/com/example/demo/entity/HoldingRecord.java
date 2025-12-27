package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HoldingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long investorId;
    
    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;
    
    private Double currentValue; // Test expects getCurrentValue()
    private LocalDateTime lastUpdated;

    // No-args constructor (Required by JPA)
    public HoldingRecord() {}

    // Constructor required by the test
    public HoldingRecord(long investorId, AssetClassType assetClass, double currentValue, LocalDateTime lastUpdated) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.lastUpdated = lastUpdated;
    }

    // Getters and Setters
    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }
    // ... other getters and setters
}