package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation_snapshot_record")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime snapshotDate;
    private double totalPortfolioValue;
    private String description;

    public AllocationSnapshotRecord() {
    }

    public AllocationSnapshotRecord(Long id, LocalDateTime snapshotDate, double totalPortfolioValue, String description) {
        this.id = id;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }

    public double getTotalPortfolioValue() { return totalPortfolioValue; }
    public void setTotalPortfolioValue(double totalPortfolioValue) { this.totalPortfolioValue = totalPortfolioValue; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
