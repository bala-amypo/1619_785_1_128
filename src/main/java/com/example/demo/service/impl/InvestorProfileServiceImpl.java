package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;

@Service
public class InvestorProfileServiceImpl {

    @Autowired
    private InvestorProfileRepository investorProfileRepository;

    // Create a new InvestorProfile
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investorProfileRepository.save(investor);
    }

    // Get InvestorProfile by ID
    public Optional<InvestorProfile> getInvestorById(Long id) {
        return investorProfileRepository.findById(id);
    }

    // Get all InvestorProfiles
    public List<InvestorProfile> getAllInvestors() {
        return investorProfileRepository.findAll();
    }

    // Optional: update an investor
    public InvestorProfile updateInvestor(Long id, InvestorProfile investorDetails) {
        InvestorProfile investor = investorProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found with id " + id));
        investor.setName(investorDetails.getName());
        investor.setEmail(investorDetails.getEmail());
        investor.setPhone(investorDetails.getPhone());
        return investorProfileRepository.save(investor);
    }

    // Optional: delete an investor
    public void deleteInvestor(Long id) {
        investorProfileRepository.deleteById(id);
    }
}
