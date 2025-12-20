package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    @Autowired
    private InvestorProfileRepository investorRepository;

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investorRepository.save(investor);
    }

    @Override
    public InvestorProfile getInvestorById(Long id) {
        return investorRepository.findById(id).orElse(null);
    }

    @Override
    public InvestorProfile findByInvestorId(String investorId) {
        return investorRepository.findByInvestorId(investorId);
    }

    @Override
    public List<InvestorProfile> getAllInvestor() {
        return investorRepository.findAll();
    }

    @Override
    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = investorRepository.findById(id).orElse(null);
        if (investor != null) {
            investor.setActive(active);
            return investorRepository.save(investor);
        }
        return null;
    }
}
