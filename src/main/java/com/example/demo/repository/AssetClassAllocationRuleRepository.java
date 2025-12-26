package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.AssetClassAllocationRule;

import org.springframework.stereotype.Repository;
@Repository
public interface AssetClassAllocationRuleRepository {
    AssetClassAllocationRule save(AssetClassAllocationRule rule);
    Optional<AssetClassAllocationRule> findById(Long id);
    List<AssetClassAllocationRule> findByInvestorId(Long investorId);
    List<AssetClassAllocationRule> findByInvestorIdAndActiveTrue(Long investorId);
    List<AssetClassAllocationRule> findActiveRulesHql(Long investorId);
}

