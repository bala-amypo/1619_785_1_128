package com.example.demo.service.impl;

import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.AllocationSnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository allocationSnapshotRecordRepository;
    private final HoldingRecordRepository holdingRecordRepository;
    private final InvestorProfileRepository investorProfileRepository;

    // ❌ NO CONSTRUCTOR
}
