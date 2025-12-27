package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AllocationSnapshot;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.AllocationSnapshotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final InvestorProfileRepository investorRepo;

    @Override
    public AllocationSnapshot save(AllocationSnapshot snapshot) {
        return snapshotRepo.save(snapshot);
    }

    @Override
    public List<AllocationSnapshot> getAllSnapshots() {
        return snapshotRepo.findAll();
    }

    @Override
    public List<AllocationSnapshot> getByInvestor(String investorId) {
        return snapshotRepo.findByInvestorId(investorId);
    }
}
