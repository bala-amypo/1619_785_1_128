package com.example.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;

@Service
@RequiredArgsConstructor
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repository;

    @Override
    public HoldingRecord create(HoldingRecord record) {
        return repository.save(record);
    }

    @Override
    public List<HoldingRecord> getByInvestor(String investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return repository.findAll();
    }
}
