package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorProfileRepository repository;

    @Autowired
    public InvestorProfileServiceImpl(InvestorProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repository.save(investor);
    }

    @Override
    public InvestorProfile getInvestorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<InvestorProfile> getAllInvestors() {
        return repository.findAll();
    }
}
