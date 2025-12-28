package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;

public interface HoldingRecordService {

    HoldingRecord recordHolding(HoldingRecord record);

    List<HoldingRecord> getHoldingsByInvestor(Long investorId);

    HoldingRecord getHoldingById(Long id);

    List<HoldingRecord> findByInvestorAndAssetClass(
            long investorId,
            AssetClassType assetClass);
}
