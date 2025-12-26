package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.impl.HoldingRecordServiceImpl;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordServiceImpl service;

    public HoldingRecordController(HoldingRecordServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HoldingRecord> create(@RequestBody HoldingRecord record) {
        return ResponseEntity.ok(service.create(record));
    }

    @GetMapping("/{investorId}")
    public ResponseEntity<List<HoldingRecord>> getByInvestor(
            @PathVariable String investorId) {
        return ResponseEntity.ok(service.getByInvestor(investorId));
    }
}
