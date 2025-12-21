package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.AllocationRuleService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository ruleRepository;
    private final InvestorProfileRepository investorProfileRepository;

    public AllocationRuleServiceImpl(
            AssetClassAllocationRuleRepository ruleRepository,
            InvestorProfileRepository investorProfileRepository) {
        this.ruleRepository = ruleRepository;
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule rule) {
        Optional<AssetClassAllocationRule> optional = ruleRepository.findById(id);
        if (optional.isPresent()) {
            AssetClassAllocationRule existing = optional.get();
            existing.setAssetClass(rule.getAssetClass());
            existing.setTargetPercentage(rule.getTargetPercentage());
            return ruleRepository.save(existing);
        }
        return null;
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        Optional<InvestorProfile> investor = investorProfileRepository.findById(investorId);
        return investor.map(ruleRepository::findByInvestor).orElse(null);
    }

    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return ruleRepository.findById(id).orElse(null);
    }

    @Override
    public List<AssetClassAllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
