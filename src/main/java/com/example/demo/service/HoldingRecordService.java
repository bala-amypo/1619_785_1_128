package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import java.util.List;

public interface HoldingRecordService {

    HoldingRecord create(HoldingRecord record);

    List<HoldingRecord> getAllHoldings();

    List<HoldingRecord> getByInvestor(String investorId);
}
