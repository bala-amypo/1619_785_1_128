package com.example.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.AllocationSnapshot;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.service.AllocationSnapshotService;

@Service
@RequiredArgsConstructor
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository repository;

    @Override
    public AllocationSnapshot create(AllocationSnapshot snapshot) {
        return repository.save(snapshot);
    }

    @Override
    public List<AllocationSnapshot> getByInvestor(String investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshot> getAllSnapshots() {
        return repository.findAll();
    }
}
