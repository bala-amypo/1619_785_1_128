package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.service.impl.AllocationRuleServiceImpl;

@RestController
@RequestMapping("/api/allocation-rules")
public class AllocationRuleController {

    private final AllocationRuleServiceImpl service;

    public AllocationRuleController(AllocationRuleServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public AssetClassAllocationRule createRule(
            @RequestBody AssetClassAllocationRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public AssetClassAllocationRule updateRule(
            @PathVariable Long id,
            @RequestBody AssetClassAllocationRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/investor/{investorId}")
    public List<AssetClassAllocationRule> getRulesByInvestor(
            @PathVariable Long investorId) {
        return service.getRulesByInvestor(investorId);
    }
}
