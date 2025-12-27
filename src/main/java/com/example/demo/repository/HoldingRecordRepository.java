package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    
    // Required by lines 628, 629 of the test
    List<HoldingRecord> findByValueGreaterThan(double value);

    // Required by lines 643, 644 of the test
    List<HoldingRecord> findByInvestorAndAssetClass(long investorId, AssetClassType assetClass);
}