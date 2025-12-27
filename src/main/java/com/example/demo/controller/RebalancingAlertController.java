package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.RebalancingAlert;
import com.example.demo.service.RebalancingAlertService;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class RebalancingAlertController {

    private final RebalancingAlertService service;

    @PostMapping
    public RebalancingAlert create(@RequestBody RebalancingAlert alert) {
        return service.create(alert);
    }

    @GetMapping("/{investorId}")
    public List<RebalancingAlert> getByInvestor(@PathVariable String investorId) {
        return service.getByInvestor(investorId);
    }
}
