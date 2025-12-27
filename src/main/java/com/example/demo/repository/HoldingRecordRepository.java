package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    // ServiceImpl needs this
    List<HoldingRecord> findByInvestorId(Long investorId);
    
    // Tests need this
    List<HoldingRecord> findByValueGreaterThan(double value);
}