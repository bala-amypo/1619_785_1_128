package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repository;

    public HoldingRecordServiceImpl(HoldingRecordRepository repository) {
        this.repository = repository;
    }

    // ===== CONTROLLER METHODS =====

    @Override
    public HoldingRecord recordHolding(HoldingRecord record) {
        return repository.save(record);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repository.findAll()
                .stream()
                .filter(r -> investorId.equals(r.getInvestorId()))
                .toList();
    }

    // ===== COMMON METHODS =====

    @Override
    public Optional<HoldingRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HoldingRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // ===== REQUIRED BY SNAPSHOT / TEST =====
    @Override
    public List<HoldingRecord> findByInvestorAndAssetClass(
            long investorId,
            AssetClassType assetClass) {
        return repository.findByInvestorIdAndAssetClass(investorId, assetClass);
    }
}
