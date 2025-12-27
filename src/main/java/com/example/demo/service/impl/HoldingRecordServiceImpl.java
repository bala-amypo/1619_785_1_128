package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    @Autowired
    private HoldingRecordRepository holdingRecordRepository;

    @Override
    public List<HoldingRecord> getAllHoldingsByUserId(Long userId) {
        return holdingRecordRepository.findByUserId(userId);
    }

    @Override
    public HoldingRecord saveHolding(HoldingRecord record) {
        return holdingRecordRepository.save(record);
    }

    // Add any other methods defined in your HoldingRecordService interface
    // such as deleteHolding or getHoldingById
}