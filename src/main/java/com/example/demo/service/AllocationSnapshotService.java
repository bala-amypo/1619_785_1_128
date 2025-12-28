package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;

public interface AllocationSnapshotService {
    List<AllocationSnapshotRecord> getAllSnapshots();
    AllocationSnapshotRecord getSnapshotById(Long id);
    AllocationSnapshotRecord saveSnapshot(AllocationSnapshotRecord snapshot);
    void deleteSnapshot(Long id);

    // Must match the service impl
    List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId);
}
