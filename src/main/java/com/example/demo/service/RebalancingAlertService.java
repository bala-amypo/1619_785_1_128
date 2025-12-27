package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RebalancingAlert;

public interface RebalancingAlertService {

    RebalancingAlert create(RebalancingAlert alert);

    List<RebalancingAlert> getByInvestor(String investorId);

    List<RebalancingAlert> getAllAlerts();
}
