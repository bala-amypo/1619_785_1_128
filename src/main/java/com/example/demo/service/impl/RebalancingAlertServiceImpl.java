package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.entity.RebalancingAlertRecord;

@Service
public class RebalancingAlertServiceImpl {

    private final List<RebalancingAlertRecord> alerts = new ArrayList<>();

    public List<RebalancingAlertRecord> getAlertsForInvestor(String investorId) { // ✅
        return alerts;
    }

    public void resolveAlert(RebalancingAlertRecord alert) {
        alert.setResolved(true);   // ✅ NOW EXISTS
    }
}
