package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.service.AllocationSnapshotService;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotService service;

    public AllocationSnapshotController(
            AllocationSnapshotService service) {
        this.service = service;
    }

    @PostMapping
    public AllocationSnapshotRecord create(
            @RequestBody AllocationSnapshotRecord record) {
        return service.createSnapshot(record);
    }

    @GetMapping("/investor/{investorId}")
    public List<AllocationSnapshotRecord> getByInvestor(
            @PathVariable Long investorId) {
        return service.getSnapshotsByInvestor(investorId);
    }
}
