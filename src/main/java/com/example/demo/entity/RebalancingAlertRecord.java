package com.example.demo.entity;

import com.example.demo.entity.enums.AlertSeverity;

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

import java.time.LocalDateTime;

@Entity
@Table(name = "rebalancing_alerts")
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
    private InvestorProfile investor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertSeverity severity;

    @Column(nullable = false)
    private String message;

    private boolean resolved;

    private LocalDateTime createdAt;

    public RebalancingAlertRecord() {
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

    public AlertSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(AlertSeverity severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
