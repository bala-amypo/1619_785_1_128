package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repository;

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
    public HoldingRecord getHoldingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));
    }

    @Override
    public List<HoldingRecord> findByInvestorAndAssetClass(
            long investorId,
            AssetClassType assetClass) {
        return repository.findByInvestorIdAndAssetClass(investorId, assetClass);
    }
}
