package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.HoldingRecord;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    List<HoldingRecord> findByInvestorId(String investorId);
}
