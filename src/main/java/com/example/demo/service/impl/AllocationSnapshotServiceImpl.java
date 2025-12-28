package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationSnapshotServiceImpl {

    private final AllocationSnapshotRecordRepository allocationSnapshotRecordRepository;

    public AllocationSnapshotServiceImpl(AllocationSnapshotRecordRepository allocationSnapshotRecordRepository) {
        this.allocationSnapshotRecordRepository = allocationSnapshotRecordRepository;
    }

    public AllocationSnapshotRecord computeSnapshot(long id) {
        // Example logic for snapshot calculation
        return allocationSnapshotRecordRepository.findById(id).orElse(new AllocationSnapshotRecord());
    }

    public AllocationSnapshotRecord getSnapshotById(long id) {
        return allocationSnapshotRecordRepository.findById(id).orElse(null);
    }

    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return allocationSnapshotRecordRepository.findAll();
    }
}
