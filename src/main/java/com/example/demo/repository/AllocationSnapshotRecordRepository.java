package com.example.demo.repository;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;
import java.util.Optional;

public interface AllocationSnapshotRecordRepository {
    AllocationSnapshotRecord save(AllocationSnapshotRecord snapshot);
    Optional<AllocationSnapshotRecord> findById(Long id);
    List<AllocationSnapshotRecord> findAll();
}
