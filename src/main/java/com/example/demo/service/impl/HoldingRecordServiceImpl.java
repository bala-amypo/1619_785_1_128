package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.HoldingRecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;
    private final InvestorProfileRepository investorProfileRepository;

    // REQUIRED constructor for tests
    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository,
                                    InvestorProfileRepository investorProfileRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
        this.investorProfileRepository = investorProfileRepository;
    }
}
