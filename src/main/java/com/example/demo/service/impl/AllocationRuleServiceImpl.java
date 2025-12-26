package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import java.util.List;

public class AllocationRuleServiceImpl {
    private final AssetClassAllocationRuleRepository allocationRuleRepository;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository allocationRuleRepository) {
        this.allocationRuleRepository = allocationRuleRepository;
    }

    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        validatePercentage(rule.getTargetPercentage());
        return allocationRuleRepository.save(rule);
    }

    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
        validatePercentage(updatedRule.getTargetPercentage());
        AssetClassAllocationRule existing = allocationRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));
        existing.setTargetPercentage(updatedRule.getTargetPercentage());
        return allocationRuleRepository.save(existing);
    }

    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return allocationRuleRepository.findByInvestorId(investorId);
    }

    private void validatePercentage(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Target percentage must be between 0 and 100");
        }
    }
}
