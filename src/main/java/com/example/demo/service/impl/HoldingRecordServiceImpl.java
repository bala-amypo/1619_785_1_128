package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.HoldingRecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRepo;
    private final InvestorProfileRepository investorRepo;

    @Override
    public HoldingRecord create(HoldingRecord record) {
        return holdingRepo.save(record);
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return holdingRepo.findAll();
    }

    @Override
    public List<HoldingRecord> getByInvestor(String investorId) {
        return holdingRepo.findByInvestorId(investorId);
    }
}
