package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AllocationSnapshot;

@Repository
public interface AllocationSnapshotRecordRepository
        extends JpaRepository<AllocationSnapshot, Long> {

    // REQUIRED BY SERVICE & CONTROLLER
    List<AllocationSnapshot> findByInvestorId(String investorId);
}
