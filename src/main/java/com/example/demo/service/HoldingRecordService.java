package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;

import java.util.List;
import java.util.Optional;

public interface HoldingRecordService {

    // USED BY CONTROLLER
    HoldingRecord recordHolding(HoldingRecord record);

    // USED BY CONTROLLER
    List<HoldingRecord> getHoldingsByInvestor(Long investorId);

    Optional<HoldingRecord> findById(Long id);

    List<HoldingRecord> findAll();

    void deleteById(Long id);

    // USED BY SNAPSHOT / TESTS
    List<HoldingRecord> findByInvestorAndAssetClass(
            long investorId,
            AssetClassType assetClass
    );
}
