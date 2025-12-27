public interface HoldingRecordService {
    HoldingRecord recordHolding(HoldingRecord record);
    List<HoldingRecord> getHoldingsByInvestor(Long investorId);
    HoldingRecord getHoldingById(long id);
    List<HoldingRecord> findByValueGreaterThan(double value);
    List<HoldingRecord> findByInvestorAndAssetClass(long investorId, AssetClassType assetClass);
}