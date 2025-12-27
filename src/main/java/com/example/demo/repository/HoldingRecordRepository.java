package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    
    // FIX 1: Add this method to resolve the Service error
    List<HoldingRecord> findByInvestorId(Long investorId);

    // FIX 2: Add this to satisfy the test requirements we saw earlier
    List<HoldingRecord> findByValueGreaterThan(double value);
}