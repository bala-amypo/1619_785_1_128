package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;

public interface AllocationSnapshotService {

    AllocationSnapshotRecord createSnapshot(AllocationSnapshotRecord snapshot);

    List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId);
}
