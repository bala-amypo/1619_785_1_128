package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    // The service calls this name specifically
    List<HoldingRecord> findByInvestorId(Long investorId);
    
    List<HoldingRecord> findByValueGreaterThan(double value);
    
    List<HoldingRecord> findByInvestorAndAssetClass(long investorId, AssetClassType assetClass);
}