package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@RequiredArgsConstructor
@Tag(name = "Holdings")
public class HoldingRecordController {

    private final HoldingRecordService holdingRecordService;

    @PostMapping
    public HoldingRecord recordHolding(@RequestBody HoldingRecord holding) {
        return holdingRecordService.recordHolding(holding);
    }

    @GetMapping("/investor/{investorId}")
    public List<HoldingRecord> getHoldingsByInvestor(
            @PathVariable Long investorId) {
        return holdingRecordService.getHoldingsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public HoldingRecord getHoldingById(@PathVariable Long id) {
        return holdingRecordService.getHoldingById(id);
    }

    @GetMapping
    public List<HoldingRecord> getAllHoldings() {
        return holdingRecordService.getAllHoldings();
    }
}
