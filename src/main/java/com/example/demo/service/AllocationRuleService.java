package com.example.demo.service;

import com.example.demo.entity.AssetClassAllocationRule;
import java.util.List;

public interface AllocationRuleService {
    AssetClassAllocationRule createRule(AssetClassAllocationRule rule);
    AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule rule);
    List<AssetClassAllocationRule> getRulesByInvestor(Long investorId);
    
    // FIX: Add this missing method to the interface
    void deleteRule(Long id);
}