package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import java.util.List;
import java.util.Optional;

public interface HoldingRecordRepository {
    HoldingRecord save(HoldingRecord record);
    Optional<HoldingRecord> findById(Long id);
    List<HoldingRecord> findByInvestorId(Long investorId);
    List<HoldingRecord> findByValueGreaterThan(Double value);
    List<HoldingRecord> findByInvestorAndAssetClass(Long investorId, AssetClassType assetClass);
}

