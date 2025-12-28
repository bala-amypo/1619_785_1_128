package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.AllocationSnapshotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository allocationSnapshotRecordRepository;
    private final HoldingRecordRepository holdingRecordRepository;
    private final AssetClassAllocationRuleRepository assetClassAllocationRuleRepository;
    private final RebalancingAlertRecordRepository rebalancingAlertRecordRepository;

    @Autowired
    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository allocationSnapshotRecordRepository,
            HoldingRecordRepository holdingRecordRepository,
            AssetClassAllocationRuleRepository assetClassAllocationRuleRepository,
            RebalancingAlertRecordRepository rebalancingAlertRecordRepository
    ) {
        this.allocationSnapshotRecordRepository = allocationSnapshotRecordRepository;
        this.holdingRecordRepository = holdingRecordRepository;
        this.assetClassAllocationRuleRepository = assetClassAllocationRuleRepository;
        this.rebalancingAlertRecordRepository = rebalancingAlertRecordRepository;
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return allocationSnapshotRecordRepository.findAll();
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return allocationSnapshotRecordRepository.findById(id).orElse(null);
    }

    @Override
    public AllocationSnapshotRecord saveSnapshot(AllocationSnapshotRecord snapshot) {
        return allocationSnapshotRecordRepository.save(snapshot);
    }

    @Override
    public void deleteSnapshot(Long id) {
        allocationSnapshotRecordRepository.deleteById(id);
    }

    // Example method using holdings and rules
    @Override
    public void createSnapshotForInvestor(Long investorId) {
        List<HoldingRecord> holdings = holdingRecordRepository.findByInvestorId(investorId);

        for (HoldingRecord h : holdings) {
            AssetClassAllocationRule rule = assetClassAllocationRuleRepository.findByAssetClass(h.getAssetClass());

            AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord();
            snapshot.setInvestorId(investorId);
            snapshot.setAssetClass(h.getAssetClass());
            snapshot.setCurrentValue(h.getValue());
            snapshot.setTargetPercentage(rule.getTargetPercentage());

            allocationSnapshotRecordRepository.save(snapshot);
        }
    }
}
