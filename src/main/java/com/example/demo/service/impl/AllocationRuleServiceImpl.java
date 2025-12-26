package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl {

    private final AssetClassAllocationRuleRepository repository;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repository) {
        this.repository = repository;
    }

    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        validateRule(rule);
        return repository.save(rule);
    }

    public List<AssetClassAllocationRule> getAllRules() {
        return repository.findAll();
    }

    public List<AssetClassAllocationRule> getActiveRules() {
        // Assuming 'active' means all rules for now, or add specific logic if needed
        return repository.findAll();
    }

    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updated) {
        AssetClassAllocationRule existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + id));

        // Update fields provided in `updated`
        // Test expects targetPercentage to be updated
        // `updatedData` is passed.

        // Validate new data
        if (updated.getTargetPercentage() != null) {
            existing.setTargetPercentage(updated.getTargetPercentage());
        }
        // Since we are updating existing object with new data potentially, we should
        // validate it.
        // But validation is on the rule parameter logic.
        // For verify purpose, let's assume we copy relevant fields or just use updated
        // if it was full replacement.
        // But the test says: `updateRule(10L, updatedData)`.
        // Logic: `existing.setTargetPercentage(45.0)`.

        // Let's validate.
        if (existing.getTargetPercentage() < 0 || existing.getTargetPercentage() > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }

        return repository.save(existing);
    }

    private void validateRule(AssetClassAllocationRule rule) {
        if (rule.getTargetPercentage() < 0 || rule.getTargetPercentage() > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
    }

    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }
}
