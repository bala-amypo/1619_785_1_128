package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import org.springframework.stereotype.Service;
import java.util.Optional; // Ensure this is imported

@Service
public class HoldingRecordServiceImpl {
    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    // FIX: Change return type from HoldingRecord to Optional<HoldingRecord>
    public Optional<HoldingRecord> getHoldingById(Long id) {
        return holdingRecordRepository.findById(id);
    }
    
    // ... other methods ...
}