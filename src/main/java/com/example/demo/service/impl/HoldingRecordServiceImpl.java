package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.InvestorProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl {

    private final HoldingRecordRepository repository;
    private final InvestorProfileRepository investorProfileRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository repository,
            InvestorProfileRepository investorProfileRepository) {
        this.repository = repository;
        this.investorProfileRepository = investorProfileRepository;
    }

    public HoldingRecord create(HoldingRecord holding) {
        return recordHolding(holding);
    }

    public List<HoldingRecord> getByInvestor(String investorId) {
        InvestorProfile profile = investorProfileRepository.findByInvestorId(investorId)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not found: " + investorId));
        return getHoldingsByInvestor(profile.getId());
    }

    public HoldingRecord recordHolding(HoldingRecord holding) {
        if (holding.getCurrentValue() <= 0) {
            throw new IllegalArgumentException("Holding value must be > 0");
        }
        return repository.save(holding);
    }

    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    public Optional<HoldingRecord> getHoldingById(Long id) {
        return repository.findById(id);
    }
}
