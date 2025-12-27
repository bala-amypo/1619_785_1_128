package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "allocation_snapshots")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String investorId;

    private String assetType;

    private Double percentage;
}
