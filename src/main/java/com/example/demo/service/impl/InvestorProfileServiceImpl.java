package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;

@Service
public class InvestorProfileServiceImpl {

    private final InvestorProfileRepository repository;

    public InvestorProfileServiceImpl(InvestorProfileRepository repository) {
        this.repository = repository;
    }

    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repository.save(investor);
    }

    public InvestorProfile getInvestorById(Long id) {
        Optional<InvestorProfile> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<InvestorProfile> getAllInvestors() {
        return repository.findAll();
    }

    public InvestorProfile updateInvestor(Long id, InvestorProfile investorDetails) {
        InvestorProfile investor = repository.findById(id).orElse(null);
        if (investor != null) {
            investor.setName(investorDetails.getName());
            investor.setEmail(investorDetails.getEmail());
            investor.setPhone(investorDetails.getPhone());
            return repository.save(investor);
        }
        return null;
    }
}
