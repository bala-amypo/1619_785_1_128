package com.example.demo.repository;

import com.example.demo.model.HoldingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    // Custom queries if needed
}
