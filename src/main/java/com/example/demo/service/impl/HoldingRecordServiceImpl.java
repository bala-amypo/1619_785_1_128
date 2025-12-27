package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repository;

    // Constructor Injection
    public HoldingRecordServiceImpl(HoldingRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public HoldingRecord saveHolding(HoldingRecord record) {
        return repository.save(record);
    }

    @Override
    public List<HoldingRecord> getHoldingsByValue(Double minValue) {
        return repository.findByValueGreaterThan(minValue);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestorAndClass(Long investorId, AssetClassType type) {
        return repository.findByInvestorIdAndAssetClass(investorId, type);
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return repository.findAll();
    }
}