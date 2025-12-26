package com.example.demo.entity;

import java.time.LocalDateTime;
import com.example.demo.entity.enums.AssetClassType;

public class HoldingRecord {

    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private Double currentValue;
    private LocalDateTime recordDate;

    public HoldingRecord(Long investorId, AssetClassType assetClass,
                         Double currentValue, LocalDateTime recordDate) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.recordDate = recordDate;
    }

    public HoldingRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getCurrentValue() { return currentValue; }
}
