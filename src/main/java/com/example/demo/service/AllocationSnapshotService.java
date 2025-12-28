package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;

import java.util.List;

public interface AllocationSnapshotService {

    // Compute or create a snapshot for a given ID
    AllocationSnapshotRecord computeSnapshot(long id);

    // Get snapshot by ID
    AllocationSnapshotRecord getSnapshotById(long id);

    // Get all snapshots
    List<AllocationSnapshotRecord> getAllSnapshots();
}
