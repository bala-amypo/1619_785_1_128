package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    // Fix 1: Add this method
    List<HoldingRecord> findByValueGreaterThan(double value);

    // Fix 2: Add this method 
    // (Note: Ensure the parameter names 'Investor' and 'AssetClass' 
    // match the field names in your HoldingRecord entity exactly)
    List<HoldingRecord> findByInvestorAndAssetClass(Long investorId, AssetClassType assetClass);
}