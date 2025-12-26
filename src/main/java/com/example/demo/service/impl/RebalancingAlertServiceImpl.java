package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertServiceImpl {

    private final RebalancingAlertRecordRepository repository;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository repository) {
        this.repository = repository;
    }

    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        // Validation per "testAlertCreationConstraintViolation": fail if
        // currentPercentage > targetPercentage?
        // Wait, the message is "currentPercentage > targetPercentage".
        // The test passes `current=50, target=60` and EXPECTS failure.
        // So 50 <= 60 implies failure?
        // If the test FAILS when current <= target, it means logic requires current >
        // target.
        // The message "currentPercentage > targetPercentage" likely means "It must be
        // that currentPercentage > targetPercentage".
        // So:
        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException("currentPercentage > targetPercentage");
        }
        return repository.save(alert);
    }

    public RebalancingAlertRecord resolveAlert(Long alertId) {
        RebalancingAlertRecord alert = repository.findById(alertId)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found: " + alertId));
        alert.setResolved(true);
        return repository.save(alert);
    }

    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }
}
