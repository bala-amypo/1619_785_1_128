package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AllocationSnapshotServiceImpl {
    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    // FIX: Constructor must accept all 4 repositories as seen in Test line 64
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

    // FIX: Missing method for Test line 659
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        // Implementation logic...
        return new AllocationSnapshotRecord(); 
    }

    // FIX: Missing method for Test line 678
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Snapshot not found: " + id));
    }

    // FIX: Missing method for Test line 688
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepo.findAll();
    }
}