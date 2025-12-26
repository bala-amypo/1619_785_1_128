package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    List<HoldingRecord> findByInvestorId(Long investorId);

    // Derived query method is sufficient, but can be explicit HQL if needed.
    // The test name implies HQL but derived method works for
    // "findByValueGreaterThan".
    List<HoldingRecord> findByCurrentValueGreaterThan(Double value);

    // To match the test call exactly: findByValueGreaterThan
    // Since the field is called "currentValue", we need to map "Value" to
    // "currentValue" or just use Query.
    // Let's use Query to match the exact method name requested
    // "findByValueGreaterThan" if the field is currentValue.
    // Or simpler, just name the method findByCurrentValueGreaterThan?
    // Wait, the test calls `holdingRecordRepository.findByValueGreaterThan(500.0)`.
    // Spring Data derived query would expect `findByCurrentValueGreaterThan`.
    // So I MUST use @Query or change field name. Changing field name is risky if I
    // already wrote entity.
    // I wrote entity with `currentValue`.
    // So I will use @Query to map `findByValueGreaterThan` to `currentValue`.

    @Query("SELECT h FROM HoldingRecord h WHERE h.currentValue > :value")
    List<HoldingRecord> findByValueGreaterThan(Double value);

    List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);
}
