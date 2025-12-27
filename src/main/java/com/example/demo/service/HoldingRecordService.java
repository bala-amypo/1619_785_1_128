package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import java.util.List;

public interface HoldingRecordService {
    HoldingRecord recordHolding(HoldingRecord record);
    List<HoldingRecord> getHoldingsByInvestor(Long investorId);
    HoldingRecord getHoldingById(long id);
    List<HoldingRecord> findByValueGreaterThan(double value);
    List<HoldingRecord> findByInvestorAndAssetClass(long investorId, AssetClassType assetClass);
}