package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    // REQUIRED by test
    List<HoldingRecord> findByInvestorAndAssetClass(
            Long investorId,
            AssetClassType assetClass);
}
