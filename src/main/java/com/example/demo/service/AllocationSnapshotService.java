package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AllocationSnapshot;

public interface AllocationSnapshotService {

    AllocationSnapshot save(AllocationSnapshot snapshot);

    List<AllocationSnapshot> getAllSnapshots();

    List<AllocationSnapshot> getByInvestor(String investorId);
}
