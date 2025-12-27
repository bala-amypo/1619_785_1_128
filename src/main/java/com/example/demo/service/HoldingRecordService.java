package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.exception.ResourceNotFoundException;

public interface HoldingRecordServiceImpl {
    private final HoldingRecordRepository repository;

    public HoldingRecordServiceImpl(HoldingRecordRepository repository) {
        this.repository = repository;
    }

    // Required by lines 246, 253 of the test
    public HoldingRecord getHoldingById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
    }
}