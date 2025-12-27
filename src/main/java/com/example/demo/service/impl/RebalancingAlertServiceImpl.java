package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RebalancingAlert;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.RebalancingAlertService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository alertRepo;
    private final InvestorProfileRepository investorRepo;

    @Override
    public RebalancingAlert save(RebalancingAlert alert) {
        return alertRepo.save(alert);
    }

    @Override
    public List<RebalancingAlert> getAllAlerts() {
        return alertRepo.findAll();
    }

    @Override
    public List<RebalancingAlert> getAlertsForInvestor(String investorId) {
        return alertRepo.findByInvestorId(investorId);
    }
}
