package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RebalancingAlert;

@Repository
public interface RebalancingAlertRecordRepository
        extends JpaRepository<RebalancingAlert, Long> {

    // REQUIRED BY SERVICE & CONTROLLER
    List<RebalancingAlert> findByInvestorId(String investorId);
}
