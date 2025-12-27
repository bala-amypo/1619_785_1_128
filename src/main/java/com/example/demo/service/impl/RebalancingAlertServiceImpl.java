package com.example.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.RebalancingAlert;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;

@Service
@RequiredArgsConstructor
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository repository;

    @Override
    public RebalancingAlert create(RebalancingAlert alert) {
        return repository.save(alert);
    }

    @Override
    public List<RebalancingAlert> getByInvestor(String investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public List<RebalancingAlert> getAllAlerts() {
        return repository.findAll();
    }
}
