package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;

@RestController
@RequestMapping("/holdings")
@RequiredArgsConstructor
public class HoldingRecordController {

    private final HoldingRecordService service;

    @PostMapping
    public HoldingRecord create(@RequestBody HoldingRecord record) {
        return service.create(record);
    }

    @GetMapping("/{investorId}")
    public List<HoldingRecord> getByInvestor(@PathVariable String investorId) {
        return service.getByInvestor(investorId);
    }
}
