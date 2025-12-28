package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import java.util.List;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);
}
