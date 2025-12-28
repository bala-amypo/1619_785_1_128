package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AllocationSnapshotServiceImpl {

    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    public AllocationSnapshotServiceImpl(
        AllocationSnapshotRecordRepository snapshotRepo,
        HoldingRecordRepository holdingRepo,
        AssetClassAllocationRuleRepository ruleRepo,
        RebalancingAlertRecordRepository alertRepo
    ) {
        this.snapshotRepo = snapshotRepo;
        this.holdingRepo = holdingRepo;
        this.ruleRepo = ruleRepo;
        this.alertRepo = alertRepo;
    }

    public AllocationSnapshotRecord computeSnapshot(long investorId) {
        // Example logic for snapshot
        double totalValue = holdingRepo.findAll() // replace with filtering by investorId
                .stream()
                .mapToDouble(h -> h.getValue())
                .sum();

        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord(
                investorId,
                totalValue,
                LocalDateTime.now()
        );

        return snapshotRepo.save(snapshot);
    }

    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepo.findAll();
    }
}
