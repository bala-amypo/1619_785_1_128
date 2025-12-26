package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.entity.enums.AssetClassType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetClassAllocationRule {

    private Long id;
    private AssetClassType assetClass;
    private double minPercentage;
    private double maxPercentage;
}
