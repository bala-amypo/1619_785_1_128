import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    Optional<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);
}
