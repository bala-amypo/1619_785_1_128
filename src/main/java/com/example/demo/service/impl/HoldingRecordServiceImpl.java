package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.entity.HoldingRecord;

@Service
public class HoldingRecordServiceImpl {

    private final List<HoldingRecord> records = new ArrayList<>();

    public HoldingRecord create(HoldingRecord record) {  // ✅ REQUIRED
        records.add(record);
        return record;
    }

    public List<HoldingRecord> getByInvestor(String investorId) { // ✅
        return records;
    }
}
