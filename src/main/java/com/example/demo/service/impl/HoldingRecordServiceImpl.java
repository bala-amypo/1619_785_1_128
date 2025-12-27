package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType; // Ensure this enum exists
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repository;

    // Constructor injection is correct
    public HoldingRecordServiceImpl(HoldingRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord record) {
        return repository.save(record);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public HoldingRecord getHoldingById(long id) {
        // Line 246 & 253 of the test call this
        return repository.findById(id).orElse(null); 
    }

    // ADD THESE TO MATCH THE TEST'S REPOSITORY CALLS
    public List<HoldingRecord> findByValueGreaterThan(double value) {
        return repository.findByValueGreaterThan(value);
    }

    public List<HoldingRecord> findByInvestorAndAssetClass(long investorId, AssetClassType assetClass) {
        return repository.findByInvestorAndAssetClass(investorId, assetClass);
    }
}