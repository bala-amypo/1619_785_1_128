package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    // Add this method
    List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);
    
    // Also add this to support the Controller's needs
    List<HoldingRecord> findByInvestorId(Long investorId);
}