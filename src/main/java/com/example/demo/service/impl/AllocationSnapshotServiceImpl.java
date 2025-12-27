package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.*;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    // These were missing! You must declare them before assigning them
    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    // Now the constructor can successfully assign the parameters to the fields
    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRepo,
            HoldingRecordRepository holdingRepo,
            AssetClassAllocationRuleRepository ruleRepo,
            RebalancingAlertRecordRepository alertRepo) {
        this.snapshotRepo = snapshotRepo;
        this.holdingRepo = holdingRepo;
        this.ruleRepo = ruleRepo;
        this.alertRepo = alertRepo;
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRepo.findByInvestorId(investorId);
    }

    @Override
    public AllocationSnapshotRecord createSnapshot(AllocationSnapshotRecord snapshot) {
        return snapshotRepo.save(snapshot);
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        return new AllocationSnapshotRecord();
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepo.findById(id).orElse(null);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepo.findAll();
    }
}