package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl {

    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    // FIX: Method name required by Test lines 220 and 228
    public HoldingRecord recordHolding(HoldingRecord holding) {
        // Validation logic required by Test line 157
        if (holding.getCurrentValue() <= 0) {
            throw new IllegalArgumentException("Holding value must be > 0");
        }
        return holdingRecordRepository.save(holding);
    }

    // FIX: Method name required by Test lines 238, 469, 502, 508
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRecordRepository.findByInvestorId(investorId);
    }

    // Ensure this returns Optional as we fixed in the previous step
    public Optional<HoldingRecord> getHoldingById(Long id) {
        return holdingRecordRepository.findById(id);
    }
}