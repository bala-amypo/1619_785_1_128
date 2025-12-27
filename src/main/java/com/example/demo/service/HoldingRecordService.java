// HoldingRecordService.java
package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import java.util.List;

public interface HoldingRecordService {
    HoldingRecord createHolding(HoldingRecord holding);
    List<HoldingRecord> getHoldingsByInvestor(Long investorId);
}
