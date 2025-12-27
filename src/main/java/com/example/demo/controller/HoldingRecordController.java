package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController { // Line 11 is around here

    @Autowired
    private HoldingRecordService service;

    @PostMapping
    public ResponseEntity<HoldingRecord> create(@RequestBody HoldingRecord record) {
        // We renamed this to recordHolding to satisfy the tests
        return ResponseEntity.ok(service.recordHolding(record));
    }

    @GetMapping("/investor/{id}")
    public ResponseEntity<List<HoldingRecord>> getByInvestor(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHoldingsByInvestor(id));
    }
}