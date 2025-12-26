package com.example.demo.entity;

import lombok.*;
import com.example.demo.entity.enums.AssetClassType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetClassAllocationRule {

    private Long id;
    private AssetClassType assetClass;

    private double targetPercentage;   // ✅ REQUIRED
    private double minPercentage;
    private double maxPercentage;
}
