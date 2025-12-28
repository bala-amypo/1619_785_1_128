package com.example.demo.service.impl;

import com.example.demo.repository.HoldingRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AllocationSnapshotServiceImpl {

    private final HoldingRecordRepository holdingRecordRepository;

    public AllocationSnapshotServiceImpl(
            HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    // existing logic remains unchanged
}
