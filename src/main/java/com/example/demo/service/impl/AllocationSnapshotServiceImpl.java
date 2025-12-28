package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.service.AllocationSnapshotService;

@Service
public class AllocationSnapshotServiceImpl
        implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository repository;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AllocationSnapshotRecord createSnapshot(
            AllocationSnapshotRecord record) {
        record.setCreatedAt(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(
            Long investorId) {
        return repository.findByInvestorId(investorId);
    }
}
