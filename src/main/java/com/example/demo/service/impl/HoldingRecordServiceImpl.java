package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    @Override
    public HoldingRecord save(HoldingRecord record) {
        return holdingRecordRepository.save(record);
    }

    @Override
    public Optional<HoldingRecord> findById(Long id) {
        return holdingRecordRepository.findById(id);
    }

    @Override
    public List<HoldingRecord> findAll() {
        return holdingRecordRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        holdingRecordRepository.deleteById(id);
    }
}
