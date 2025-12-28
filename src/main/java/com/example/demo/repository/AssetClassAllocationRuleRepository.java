package com.example.demo.repository;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetClassAllocationRuleRepository extends JpaRepository<AssetClassAllocationRule, Long> {
    AssetClassAllocationRule findByAssetClass(AssetClassType assetClass);
    List<Entity> findByInvestorId(Long investorId);
}
