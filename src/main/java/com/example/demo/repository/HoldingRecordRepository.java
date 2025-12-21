package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.InvestorProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRecordRepository
        extends JpaRepository<HoldingRecord, Long> {

    List<HoldingRecord> findByInvestor(InvestorProfile investor);
}
