package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    
    // Fix: Add missing method found in Test line 643
    List<HoldingRecord> findByInvestorAndAssetClass(Long investorId, AssetClassType assetClass);

    List<HoldingRecord> findByInvestorId(Long investorId);
    List<HoldingRecord> findByValueGreaterThan(Double value);
}