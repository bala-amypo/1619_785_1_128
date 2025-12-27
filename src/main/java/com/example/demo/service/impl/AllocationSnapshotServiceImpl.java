package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.AllocationSnapshotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository allocationRepo;
    private final HoldingRecordRepository holdingRepo;
    private final InvestorProfileRepository investorRepo;

    // REQUIRED constructor for tests
    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository allocationRepo,
            HoldingRecordRepository holdingRepo,
            InvestorProfileRepository investorRepo) {
        this.allocationRepo = allocationRepo;
        this.holdingRepo = holdingRepo;
        this.investorRepo = investorRepo;
    }
}
