package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.RebalancingAlert;

public interface RebalancingAlertRecordRepository
        extends JpaRepository<RebalancingAlert, Long> {

    List<RebalancingAlert> findByInvestorId(String investorId);
}
