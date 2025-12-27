package com.example.demo.service.impl;

import com.example.demo.service.InvestorProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.entity.InvestorProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorProfileRepository repository;

    public InvestorProfileServiceImpl(InvestorProfileRepository repository) {
        this.repository = repository;
    }

   @Override
public Optional<InvestorProfile> findByInvestorId(Long investorId) {
    return repository.findByInvestorId(investorId);
}

@Override
public InvestorProfile updateInvestorStatus(Long id, boolean active) {
    InvestorProfile investor = getInvestorById(id);
    investor.setActive(active);
    return repository.save(investor);
}
}
