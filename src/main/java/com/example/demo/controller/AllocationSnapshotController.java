package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.service.impl.AllocationSnapshotServiceImpl;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotServiceImpl service;

    public AllocationSnapshotController(AllocationSnapshotServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{investorId}")
    public ResponseEntity<List<AllocationSnapshotRecord>> getSnapshots(
            @PathVariable String investorId) {
        return ResponseEntity.ok(service.getByInvestor(investorId));
    }
}
