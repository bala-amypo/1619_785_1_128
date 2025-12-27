package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;

    // FIX: Add constructor with arguments as required by line 63 of the test
    @Autowired
    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    // FIX: Rename createHolding to recordHolding as required by lines 220 & 228
    @Override
    public HoldingRecord recordHolding(HoldingRecord record) {
        return holdingRecordRepository.save(record);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRecordRepository.findByInvestorId(investorId);
    }

    // FIX: Add getHoldingById as required by lines 246 & 253
    @Override
    public HoldingRecord getHoldingById(long id) {
        return holdingRecordRepository.findById(id).orElse(null);
    }
}