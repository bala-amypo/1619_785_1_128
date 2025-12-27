package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PostMapping
public ResponseEntity<HoldingRecord> create(@RequestBody HoldingRecord record) {
    // FIX: Change .createHolding to .recordHolding
    return ResponseEntity.ok(service.recordHolding(record));
}