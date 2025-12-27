package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AllocationSnapshot;

public interface AllocationSnapshotService {

    AllocationSnapshot create(AllocationSnapshot snapshot);

    List<AllocationSnapshot> getByInvestor(String investorId);

    List<AllocationSnapshot> getAllSnapshots();
}
