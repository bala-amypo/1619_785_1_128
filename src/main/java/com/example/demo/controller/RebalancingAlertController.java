package com.example.demo.controller;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.RebalancingAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
@Tag(name = "Rebalancing Alerts")
public class RebalancingAlertController {

    private final RebalancingAlertService alertService;

    @PostMapping
    public RebalancingAlertRecord createAlert(
            @RequestBody RebalancingAlertRecord alert) {
        return alertService.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public RebalancingAlertRecord resolveAlert(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> getAlertsByInvestor(
            @PathVariable Long investorId) {
        return alertService.getAlertsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public RebalancingAlertRecord getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
