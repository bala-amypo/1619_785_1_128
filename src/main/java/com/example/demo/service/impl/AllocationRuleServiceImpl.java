package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service; // ADD THIS IMPORT

import java.util.List;

@Service // ADD THIS ANNOTATION
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository repository;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        validatePercentage(rule.getTargetPercentage());
        return repository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule rule) {
        AssetClassAllocationRule existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Allocation rule not found with id " + id));

        validatePercentage(rule.getTargetPercentage());
        existing.setTargetPercentage(rule.getTargetPercentage());
        existing.setActive(rule.getActive());
        return repository.save(existing);
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    // Standard method usually required by the Controller/Test
    @Override
    public void deleteRule(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Rule not found");
        }
        repository.deleteById(id);
    }

    private void validatePercentage(Double percentage) {
        if (percentage == null || percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Target percentage must be between 0 and 100");
        }
    }
}