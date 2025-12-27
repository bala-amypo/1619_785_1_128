package com.example.demo.service;

import com.example.demo.entity.InvestorProfile;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class InvestorProfileService {

    InvestorProfile createInvestor(InvestorProfile investor);

    InvestorProfile getInvestorById(Long id);

    List<InvestorProfile> getAllInvestors();

    InvestorProfile updateInvestorStatus(Long id, Boolean active);

    Optional<InvestorProfile> findByInvestorId(String investorId);
    void deleteInvestor(Long investorId);

}
