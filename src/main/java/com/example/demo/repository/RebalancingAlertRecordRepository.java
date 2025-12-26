package com.example.demo.repository;

import com.example.demo.entity.RebalancingAlertRecord;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
@Repository
public interface RebalancingAlertRecordRepository {
    RebalancingAlertRecord save(RebalancingAlertRecord alert);
    Optional<RebalancingAlertRecord> findById(Long id);
    List<RebalancingAlertRecord> findByInvestorId(Long investorId);
}

