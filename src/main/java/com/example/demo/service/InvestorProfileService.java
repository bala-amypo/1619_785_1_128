package com.example.demo.service;

import com.example.demo.entity.InvestorProfile;

import java.util.List;
import java.util.Optional;

public interface InvestorProfileService {

    @Override
public Optional<InvestorProfile> findByInvestorId(Long investorId) {
    return repository.findByInvestorId(investorId);
}
    InvestorProfile getInvestorById(Long id);

    List<InvestorProfile> getAllInvestors();

    InvestorProfile updateInvestorStatus(Long id, boolean active);

    Optional<InvestorProfile> findByInvestorId(Long investorId);
}
