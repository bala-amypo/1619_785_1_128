package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AssetClassAllocationRule> create(
            @RequestBody AssetClassAllocationRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<AssetClassAllocationRule>> getAll() {
        return ResponseEntity.ok(service.getAllRules());
    }
}
