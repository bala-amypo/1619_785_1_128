package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RebalancingAlert;

public interface RebalancingAlertService {

    RebalancingAlert save(RebalancingAlert alert);

    List<RebalancingAlert> getAllAlerts();

    List<RebalancingAlert> getAlertsForInvestor(String investorId);
}
