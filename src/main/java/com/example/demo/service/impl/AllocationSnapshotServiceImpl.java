package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.AllocationSnapshotService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRepository;
    private final HoldingRecordRepository holdingRecordRepository;
    private final InvestorProfileRepository investorProfileRepository;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRepository,
            HoldingRecordRepository holdingRecordRepository,
            InvestorProfileRepository investorProfileRepository) {
        this.snapshotRepository = snapshotRepository;
        this.holdingRecordRepository = holdingRecordRepository;
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        Optional<InvestorProfile> investorOpt = investorProfileRepository.findById(investorId);
        if (investorOpt.isEmpty()) {
            return null;
        }

        List<HoldingRecord> holdings =
                holdingRecordRepository.findByInvestor(investorOpt.get());

        double total = holdings.stream()
                .mapToDouble(HoldingRecord::getCurrentValue)
                .sum();

        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord();
        snapshot.setInvestor(investorOpt.get());
        snapshot.setTotalValue(total);
        snapshot.setSnapshotTime(LocalDateTime.now());

        return snapshotRepository.save(snapshot);
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        Optional<InvestorProfile> investor = investorProfileRepository.findById(investorId);
        return investor.map(snapshotRepository::findByInvestor).orElse(null);
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepository.findById(id).orElse(null);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepository.findAll();
    }
}
