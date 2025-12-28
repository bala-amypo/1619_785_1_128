package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "investor_id", nullable = false)
    private Long investorId;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "current_value")
    private Double currentValue;

    // ===== REQUIRED BY TESTS =====

    public Long getId() {
        return id;
    }

    // Test explicitly uses this
    public void setId(Long id) {
        this.id = id;
    }

    // Test explicitly uses this
    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    // ===== STANDARD GETTERS / SETTERS =====

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }
}
