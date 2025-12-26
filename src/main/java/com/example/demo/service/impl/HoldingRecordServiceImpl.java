package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import java.util.List;
import java.util.Optional;

public class HoldingRecordServiceImpl {
    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    public HoldingRecord recordHolding(HoldingRecord holding) {
        validateValue(holding.getCurrentValue());
        return holdingRecordRepository.save(holding);
    }

    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRecordRepository.findByInvestorId(investorId);
    }

    public Optional<HoldingRecord> getHoldingById(Long id) {
        return holdingRecordRepository.findById(id);
    }

    private void validateValue(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Holding value must be > 0");
        }
    }
}
