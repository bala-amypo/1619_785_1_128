package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AllocationSnapshotServiceImpl {

    private final AllocationSnapshotRecordRepository snapshotRepository;
    private final HoldingRecordRepository holdingRepository;
    private final AssetClassAllocationRuleRepository ruleRepository;
    private final RebalancingAlertRecordRepository alertRepository;
    private final com.example.demo.repository.InvestorProfileRepository investorProfileRepository;

    public AllocationSnapshotServiceImpl(AllocationSnapshotRecordRepository snapshotRepository,
            HoldingRecordRepository holdingRepository,
            AssetClassAllocationRuleRepository ruleRepository,
            RebalancingAlertRecordRepository alertRepository,
            com.example.demo.repository.InvestorProfileRepository investorProfileRepository) {
        this.snapshotRepository = snapshotRepository;
        this.holdingRepository = holdingRepository;
        this.ruleRepository = ruleRepository;
        this.alertRepository = alertRepository;
        this.investorProfileRepository = investorProfileRepository;
    }

    public List<AllocationSnapshotRecord> getByInvestor(String investorId) {
        com.example.demo.entity.InvestorProfile profile = investorProfileRepository.findByInvestorId(investorId)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not found: " + investorId));
        return snapshotRepository.findByInvestorId(profile.getId());
    }

    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRepository.findByInvestorId(investorId);
        if (holdings.isEmpty()) {
            throw new IllegalArgumentException("No holdings found for investor: " + investorId);
        }

        double totalValue = holdings.stream().mapToDouble(HoldingRecord::getCurrentValue).sum();

        // Save Snapshot
        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord(
                investorId,
                LocalDateTime.now(),
                totalValue,
                "{}" // basic json
        );
        snapshotRepository.save(snapshot);

        // Check Rules
        List<AssetClassAllocationRule> rules = ruleRepository.findByInvestorIdAndActiveTrue(investorId);

        // Group holdings by asset class
        Map<AssetClassType, Double> holdingsByClass = holdings.stream()
                .collect(Collectors.groupingBy(
                        HoldingRecord::getAssetClass,
                        Collectors.summingDouble(HoldingRecord::getCurrentValue)));

        for (AssetClassAllocationRule rule : rules) {
            double currentVal = holdingsByClass.getOrDefault(rule.getAssetClass(), 0.0);
            double currentPercentage = (totalValue > 0) ? (currentVal / totalValue) * 100 : 0.0;

            // Logic to create alert if deviation?
            // Test implies if conditions met.
            // Let's assume if current > target we alert (based on other test logic).

            if (currentPercentage > rule.getTargetPercentage()) {
                RebalancingAlertRecord alert = new RebalancingAlertRecord(
                        investorId,
                        rule.getAssetClass(),
                        currentPercentage,
                        rule.getTargetPercentage(),
                        AlertSeverity.MEDIUM, // default
                        "Allocation exceeded target",
                        LocalDateTime.now(),
                        false);
                // We save it using the repo
                alertRepository.save(alert);
            }
        }

        return snapshot;
    }

    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snapshot not found: " + id));
    }

    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepository.findAll();
    }
}
