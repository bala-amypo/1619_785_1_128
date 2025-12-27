package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.RebalancingAlertService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository alertRepo;
    private final InvestorProfileRepository investorRepo;

    // REQUIRED constructor for tests
    public RebalancingAlertServiceImpl(
            RebalancingAlertRecordRepository alertRepo,
            InvestorProfileRepository investorRepo) {
        this.alertRepo = alertRepo;
        this.investorRepo = investorRepo;
    }
}
