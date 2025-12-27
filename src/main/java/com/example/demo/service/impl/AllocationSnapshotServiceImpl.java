package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.service.AllocationSnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository repository;

    @Override
    public AllocationSnapshotRecord create(AllocationSnapshotRecord record) {
        return repository.save(record);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return repository.findAll();
    }

    @Override
    public List<AllocationSnapshotRecord> getByInvestor(String investorId) {
        return repository.findByInvestorId(investorId);
    }
}
