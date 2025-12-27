package com.example.demo.service.impl;

import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.HoldingRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;
    private final InvestorProfileRepository investorProfileRepository;

    // ❌ NO CONSTRUCTOR HERE
}
