package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorProfileRepository investorProfileRepository;

    public InvestorProfileServiceImpl(InvestorProfileRepository investorProfileRepository) {
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investorProfileRepository.save(investor);
    }

    @Override
    public InvestorProfile getInvestorById(Long id) {
        Optional<InvestorProfile> optional = investorProfileRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<InvestorProfile> getAllInvestors() {
        return investorProfileRepository.findAll();
    }

    @Override
    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = getInvestorById(id);
        if (investor != null) {
            investor.setActive(active);
            return investorProfileRepository.save(investor);
        }
        return null;
    }

    @Override
    public InvestorProfile findByInvestorId(String investorId) {
        return investorProfileRepository.findByInvestorId(investorId);
    }
}
