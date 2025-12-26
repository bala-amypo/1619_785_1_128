package com.example.demo.repository;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
@Repository
public interface AllocationSnapshotRecordRepository {
    AllocationSnapshotRecord save(AllocationSnapshotRecord record);
    Optional<AllocationSnapshotRecord> findById(Long id);
    List<AllocationSnapshotRecord> findAll();
}

