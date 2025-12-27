package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.AllocationSnapshot;

public interface AllocationSnapshotRecordRepository
        extends JpaRepository<AllocationSnapshot, Long> {

    List<AllocationSnapshot> findByInvestorId(String investorId);
}
