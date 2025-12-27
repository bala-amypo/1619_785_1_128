package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import java.util.List;

public interface HoldingRecordService {
    HoldingRecord saveHolding(HoldingRecord record);
    List<HoldingRecord> getHoldingsByValue(Double minValue);
    List<HoldingRecord> getHoldingsByInvestorAndClass(Long investorId, AssetClassType type);
    List<HoldingRecord> getAllHoldings();
}