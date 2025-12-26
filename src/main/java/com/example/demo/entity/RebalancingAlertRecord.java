package com.example.demo.entity;

import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class RebalancingAlertRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double currentPercentage;
    private Double targetPercentage;

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity;

    private String message;
    private LocalDateTime timestamp;
    private Boolean resolved;

    public RebalancingAlertRecord(Long investorId, AssetClassType assetClass, Double currentPercentage,
            Double targetPercentage, AlertSeverity severity, String message, LocalDateTime timestamp,
            Boolean resolved) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.timestamp = timestamp;
        this.resolved = resolved;
    }
}
