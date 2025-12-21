package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository alertRepository;
    private final InvestorProfileRepository investorProfileRepository;

    public RebalancingAlertServiceImpl(
            RebalancingAlertRecordRepository alertRepository,
            InvestorProfileRepository investorProfileRepository) {
        this.alertRepository = alertRepository;
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        alert.setCreatedAt(LocalDateTime.now());
        alert.setResolved(false);
        return alertRepository.save(alert);
    }

    @Override
    public RebalancingAlertRecord resolveAlert(Long id) {
        Optional<RebalancingAlertRecord> optional = alertRepository.findById(id);
        if (optional.isPresent()) {
            RebalancingAlertRecord alert = optional.get();
            alert.setResolved(true);
            return alertRepository.save(alert);
        }
        return null;
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        Optional<InvestorProfile> investor = investorProfileRepository.findById(investorId);
        return investor.map(alertRepository::findByInvestor).orElse(null);
    }

    @Override
    public RebalancingAlertRecord getAlertById(Long id) {
        return alertRepository.findById(id).orElse(null);
    }

    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertRepository.findAll();
    }
}
