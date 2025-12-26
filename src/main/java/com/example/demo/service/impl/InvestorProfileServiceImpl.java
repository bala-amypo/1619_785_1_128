package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InvestorProfileRepository;
import java.util.List;
import java.util.Optional;

public class InvestorProfileServiceImpl {
    private final InvestorProfileRepository investorProfileRepository;

    public InvestorProfileServiceImpl(InvestorProfileRepository investorProfileRepository) {
        this.investorProfileRepository = investorProfileRepository;
    }

    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investorProfileRepository.save(investor);
    }

    public InvestorProfile getInvestorById(Long id) {
        return investorProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not found with id: " + id));
    }

    public List<InvestorProfile> getAllInvestors() {
        return investorProfileRepository.findAll();
    }

    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = investorProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not found with id: " + id));
        investor.setActive(active);
        return investorProfileRepository.save(investor);
    }

    public Optional<InvestorProfile> findByInvestorId(String investorId) {
        return investorProfileRepository.findByInvestorId(investorId);
    }
}
