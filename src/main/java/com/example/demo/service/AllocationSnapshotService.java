package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;

import java.util.List;

public interface AllocationSnapshotService {

    // USED BY CONTROLLER
    AllocationSnapshotRecord createSnapshot(
            AllocationSnapshotRecord record);

    // USED BY CONTROLLER
    List<AllocationSnapshotRecord> getSnapshotsByInvestor(
            Long investorId);
}
