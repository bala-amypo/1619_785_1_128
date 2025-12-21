package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
    private InvestorProfile investor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetClassType assetClass;

    @Column(nullable = false)
    private double currentValue;

    public HoldingRecord() {
    }

    public Long getId() {
        return id;
    }

    public InvestorProfile getInvestor() {
        return investor;
    }

    public void setInvestor(InvestorProfile investor) {
        this.investor = investor;
    }

    public AssetClassType getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(AssetClassType assetClass) {
        this.assetClass = assetClass;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}
