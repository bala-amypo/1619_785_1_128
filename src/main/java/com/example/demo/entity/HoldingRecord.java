package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private double quantity;
    private double price;

    // ✅ REQUIRED BY TEST
    public double getCurrentValue() {
        return quantity * price;
    }

    // getters & setters
}
