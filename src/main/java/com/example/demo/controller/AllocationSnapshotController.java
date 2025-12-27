package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.AllocationSnapshot;
import com.example.demo.service.AllocationSnapshotService;

@RestController
@RequestMapping("/snapshots")
@RequiredArgsConstructor
public class AllocationSnapshotController {

    private final AllocationSnapshotService service;

    @PostMapping
    public AllocationSnapshot create(@RequestBody AllocationSnapshot snapshot) {
        return service.create(snapshot);
    }

    @GetMapping("/{investorId}")
    public List<AllocationSnapshot> getByInvestor(@PathVariable String investorId) {
        return service.getByInvestor(investorId);
    }
}
