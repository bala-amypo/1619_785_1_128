package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;

public interface AllocationSnapshotService {

    AllocationSnapshotRecord createSnapshot(AllocationSnapshotRecord record);

    AllocationSnapshotRecord getSnapshotById(long id);

    List<AllocationSnapshotRecord> getAllSnapshots();

    List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId);
}
