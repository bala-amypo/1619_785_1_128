package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository repository;

    @Override
    public RebalancingAlertRecord create(RebalancingAlertRecord record) {
        return repository.save(record);
    }

    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsForInvestor(String investorId) {
        return repository.findByInvestorId(investorId);
    }
}
