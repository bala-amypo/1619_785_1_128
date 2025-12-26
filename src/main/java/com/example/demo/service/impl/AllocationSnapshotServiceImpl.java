package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import com.example.demo.entity.AllocationSnapshotRecord;

@Service
public class AllocationSnapshotServiceImpl {

    private final List<AllocationSnapshotRecord> snapshots = new ArrayList<>();

    public AllocationSnapshotRecord save(AllocationSnapshotRecord record) {
        record.setCapturedAt(LocalDateTime.now());
        snapshots.add(record);
        return record;
    }

    public List<AllocationSnapshotRecord> getByInvestor(String investorId) { // ✅
        return snapshots;
    }
}
