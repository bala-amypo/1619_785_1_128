package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository allocationSnapshotRecordRepository;

    public AllocationSnapshotServiceImpl(AllocationSnapshotRecordRepository allocationSnapshotRecordRepository) {
        this.allocationSnapshotRecordRepository = allocationSnapshotRecordRepository;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(long id) {
        return allocationSnapshotRecordRepository.findById(id).orElse(new AllocationSnapshotRecord());
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(long id) {
        return allocationSnapshotRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return allocationSnapshotRecordRepository.findAll();
    }
}
