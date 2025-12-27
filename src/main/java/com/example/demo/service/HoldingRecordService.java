package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.HoldingRecord;

public interface HoldingRecordService {

    HoldingRecord create(HoldingRecord record);

    List<HoldingRecord> getAllHoldings();

    List<HoldingRecord> getByInvestor(String investorId);
}
