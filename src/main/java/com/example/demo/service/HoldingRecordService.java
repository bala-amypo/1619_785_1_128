package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import java.util.List;

public interface HoldingRecordService {
    // Rename/Add these to match what the Controller wants
    HoldingRecord recordHolding(HoldingRecord record);
    List<HoldingRecord> getHoldingsByInvestor(Long investorId);
}