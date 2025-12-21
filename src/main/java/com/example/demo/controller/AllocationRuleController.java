package com.example.demo.controller;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.service.AllocationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocation-rules")
@RequiredArgsConstructor
@Tag(name = "Allocation Rules")
public class AllocationRuleController {

    private final AllocationRuleService allocationRuleService;

    @PostMapping
    public AssetClassAllocationRule createRule(
            @RequestBody AssetClassAllocationRule rule) {
        return allocationRuleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public AssetClassAllocationRule updateRule(@PathVariable Long id,
                                               @RequestBody AssetClassAllocationRule rule) {
        return allocationRuleService.updateRule(id, rule);
    }

    @GetMapping("/investor/{investorId}")
    public List<AssetClassAllocationRule> getRulesByInvestor(
            @PathVariable Long investorId) {
        return allocationRuleService.getRulesByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AssetClassAllocationRule getRuleById(@PathVariable Long id) {
        return allocationRuleService.getRuleById(id);
    }

    @GetMapping
    public List<AssetClassAllocationRule> getAllRules() {
        return allocationRuleService.getAllRules();
    }
}
