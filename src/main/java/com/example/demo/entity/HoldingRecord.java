package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.entity.enums.AssetClassType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoldingRecord {

    private Long id;
    private String investorId;
    private AssetClassType assetClass;
    private double currentValue;
}
