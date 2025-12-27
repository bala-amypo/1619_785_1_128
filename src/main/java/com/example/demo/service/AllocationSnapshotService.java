package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;

public interface AllocationSnapshotService {
    // Controller line 22 expects this:
    AllocationSnapshotRecord createSnapshot(AllocationSnapshotRecord snapshot);
    
    // Controller line 27 expects this:
    List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId);

    // Keep these if other parts of your code or tests use them
    AllocationSnapshotRecord computeSnapshot(Long investorId);
    AllocationSnapshotRecord getSnapshotById(Long id);
    List<AllocationSnapshotRecord> getAllSnapshots();
}