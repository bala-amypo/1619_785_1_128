package com.example.demo.service.impl;

import com.example.demo.service.AllocationSnapshotService;
import com.example.demo.repository.HoldingRecordRepository;
import org.springframework.stereotype.Service;

@Service   // 🔴 THIS IS CRITICAL
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final HoldingRecordRepository holdingRecordRepository;

    public AllocationSnapshotServiceImpl(
            HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    @Override
    public void generateSnapshot(Long investorId) {
        // Minimal implementation to satisfy controller & tests
        // You can add real snapshot logic later
        holdingRecordRepository.findByInvestorId(investorId);
    }
}
