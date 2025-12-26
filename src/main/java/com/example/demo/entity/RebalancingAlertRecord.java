package com.example.demo.entity;

import java.time.LocalDateTime;
import com.example.demo.entity.enums.*;

public class RebalancingAlertRecord {

    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private Double currentPercentage;
    private Double targetPercentage;
    private AlertSeverity severity;
    private String message;
    private LocalDateTime createdDate;
    private Boolean resolved;

    public RebalancingAlertRecord(Long investorId, AssetClassType assetClass,
                                  Double currentPercentage, Double targetPercentage,
                                  AlertSeverity severity, String message,
                                  LocalDateTime createdDate, Boolean resolved) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.createdDate = createdDate;
        this.resolved = resolved;
    }

    public RebalancingAlertRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getCurrentPercentage() { return currentPercentage; }
    public Double getTargetPercentage() { return targetPercentage; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public AlertSeverity getSeverity() { return severity; }
}
