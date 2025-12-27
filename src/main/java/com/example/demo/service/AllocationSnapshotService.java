package com.example.demo.service;

import com.example.demo.entity.AllocationSnapshotRecord;
import java.util.List;

public interface AllocationSnapshotService {

    AllocationSnapshotRecord create(AllocationSnapshotRecord record);

    List<AllocationSnapshotRecord> getAllSnapshots();

    List<AllocationSnapshotRecord> getByInvestor(String investorId);
}
