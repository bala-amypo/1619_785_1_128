package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllocationRuleServiceImpl {

    private final List<AssetClassAllocationRule> rules = new ArrayList<>();

    // ✅ ADD THIS METHOD (this fixes the error)
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        rules.add(rule);
        return rule;
    }

    // (Optional, but useful)
    public List<AssetClassAllocationRule> getAllRules() {
        return rules;
    }
}
