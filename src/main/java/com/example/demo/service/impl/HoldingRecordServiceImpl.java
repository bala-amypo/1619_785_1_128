package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.HoldingRecordService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;
    private final InvestorProfileRepository investorProfileRepository;

    public HoldingRecordServiceImpl(
            HoldingRecordRepository holdingRecordRepository,
            InvestorProfileRepository investorProfileRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord holding) {
        return holdingRecordRepository.save(holding);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        Optional<InvestorProfile> investor = investorProfileRepository.findById(investorId);
        return investor.map(holdingRecordRepository::findByInvestor).orElse(null);
    }

    @Override
    public HoldingRecord getHoldingById(Long id) {
        return holdingRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return holdingRecordRepository.findAll();
    }
}
