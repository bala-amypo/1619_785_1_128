package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HoldingRecord;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    // REQUIRED BY SERVICE & CONTROLLER
    List<HoldingRecord> findByInvestorId(String investorId);
}
