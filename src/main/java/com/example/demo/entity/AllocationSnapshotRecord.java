package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class AllocationSnapshotRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;
    private LocalDateTime snapshotDate;
    private Double totalPortfolioValue;

    @Lob
    private String detailJson;

    public AllocationSnapshotRecord(Long investorId, LocalDateTime snapshotDate, Double totalPortfolioValue,
            String detailJson) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.detailJson = detailJson;
    }
}
