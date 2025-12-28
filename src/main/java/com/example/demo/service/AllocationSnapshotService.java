package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AllocationSnapshotRecord;

public interface AllocationSnapshotService {

    AllocationSnapshotRecord createSnapshot(AllocationSnapshotRecord record);

    List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId);
}
