package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    // CHANGE THIS: from findByInvestorAndAssetClass to findByInvestorIdAndAssetClass
    List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);

    // Ensure this also uses InvestorId
    List<HoldingRecord> findByInvestorId(Long investorId);
}