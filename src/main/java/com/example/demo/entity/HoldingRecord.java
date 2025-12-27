package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HoldingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId; // Used in findByInvestorAndAssetClass

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double value; // Used in findByValueGreaterThan
    
    private String assetName;
    private Integer quantity;
}