package com.example.demo.repository;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.entity.InvestorProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebalancingAlertRecordRepository
        extends JpaRepository<RebalancingAlertRecord, Long> {

    List<RebalancingAlertRecord> findByInvestor(InvestorProfile investor);
}
