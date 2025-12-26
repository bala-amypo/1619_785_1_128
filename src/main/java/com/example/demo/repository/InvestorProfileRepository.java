package com.example.demo.repository;

import com.example.demo.entity.InvestorProfile;
import java.util.List;
import java.util.Optional;

public interface InvestorProfileRepository {
    InvestorProfile save(InvestorProfile investor);
    Optional<InvestorProfile> findById(Long id);
    List<InvestorProfile> findAll();
    Optional<InvestorProfile> findByInvestorId(String investorId);
}
