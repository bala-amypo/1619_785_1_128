package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "holding_record")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double currentValue;

    @Enumerated(EnumType.STRING)
    private com.example.demo.entity.enums.AssetClassType assetClassType;

    private LocalDateTime createdAt;

    public HoldingRecord() {
    }

    public HoldingRecord(String name, double currentValue, com.example.demo.entity.enums.AssetClassType assetClassType) {
        this.name = name;
        this.currentValue = currentValue;
        this.assetClassType = assetClassType;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCurrentValue() { return currentValue; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }

    public com.example.demo.entity.enums.AssetClassType getAssetClassType() { return assetClassType; }
    public void setAssetClassType(com.example.demo.entity.enums.AssetClassType assetClassType) { this.assetClassType = assetClassType; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
