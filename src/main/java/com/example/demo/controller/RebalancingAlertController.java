package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.impl.RebalancingAlertServiceImpl;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {

    private final RebalancingAlertServiceImpl service;

    public RebalancingAlertController(RebalancingAlertServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{investorId}")
    public ResponseEntity<List<RebalancingAlertRecord>> getAlerts(
            @PathVariable String investorId) {
        return ResponseEntity.ok(service.getAlertsForInvestor(investorId));
    }
}
