package com.example.demo.entity;

import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import java.time.LocalDateTime;

public class RebalancingAlertRecord {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private double currentPercentage;
    private double targetPercentage;
    private AlertSeverity severity;
    private String message;
    private LocalDateTime alertDate;
    private boolean resolved;

    public RebalancingAlertRecord(Long investorId, AssetClassType assetClass, double currentPercentage, 
                                double targetPercentage, AlertSeverity severity, String message, 
                                LocalDateTime alertDate, boolean resolved) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.alertDate = alertDate;
        this.resolved = resolved;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public double getCurrentPercentage() { return currentPercentage; }
    public double getTargetPercentage() { return targetPercentage; }
    public AlertSeverity getSeverity() { return severity; }
    public String getMessage() { return message; }
    public LocalDateTime getAlertDate() { return alertDate; }
    public boolean getResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
