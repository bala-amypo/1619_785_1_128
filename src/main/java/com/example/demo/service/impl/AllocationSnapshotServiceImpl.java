package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRepository;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationSnapshotServiceImpl
        implements AllocationSnapshotService {

    private final AllocationSnapshotRepository repository;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRepository repository) {
        this.repository = repository;
    }

    @Override
    public AllocationSnapshotRecord createSnapshot(
            AllocationSnapshotRecord record) {
        return repository.save(record);
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(
            Long investorId) {
        return repository.findByInvestorId(investorId);
    }
}
