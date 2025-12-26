package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.entity.AssetClassAllocationRule;

@Service
public class AllocationRuleServiceImpl {

    private final List<AssetClassAllocationRule> rules = new ArrayList<>();

    public AssetClassAllocationRule save(AssetClassAllocationRule rule) {
        rules.add(rule);
        return rule;
    }

    public List<AssetClassAllocationRule> getAllRules() {   // ✅ REQUIRED
        return rules;
    }
}
