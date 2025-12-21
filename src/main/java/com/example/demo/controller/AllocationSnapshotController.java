package com.example.demo.controller;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.service.AllocationSnapshotService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
@RequiredArgsConstructor
@Tag(name = "Allocation Snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotService snapshotService;

    @PostMapping("/compute/{investorId}")
    public AllocationSnapshotRecord computeSnapshot(
            @PathVariable Long investorId) {
        return snapshotService.computeSnapshot(investorId);
    }

    @GetMapping("/investor/{investorId}")
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(
            @PathVariable Long investorId) {
        return snapshotService.getSnapshotsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AllocationSnapshotRecord getSnapshotById(@PathVariable Long id) {
        return snapshotService.getSnapshotById(id);
    }

    @GetMapping
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotService.getAllSnapshots();
    }
}
