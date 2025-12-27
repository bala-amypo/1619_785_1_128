package com.example.demo.service.impl;

import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.RebalancingAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository rebalancingAlertRecordRepository;
    private final InvestorProfileRepository investorProfileRepository;

    // ❌ NO CONSTRUCTOR
}
