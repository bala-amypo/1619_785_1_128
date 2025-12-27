package com.example.demo.service;

import com.example.demo.entity.RebalancingAlertRecord;
import java.util.List;

public interface RebalancingAlertService {

    RebalancingAlertRecord create(RebalancingAlertRecord record);

    List<RebalancingAlertRecord> getAllAlerts();

    List<RebalancingAlertRecord> getAlertsForInvestor(String investorId);
}
