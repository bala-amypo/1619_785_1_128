package com.example.demo.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetClassAllocationRule{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long investorId;
    private Double targetPercentage;
    private AssetClassType assetClass;
    private boolean active;

}