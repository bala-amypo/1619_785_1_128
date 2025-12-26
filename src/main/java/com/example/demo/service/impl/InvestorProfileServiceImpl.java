package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorProfileServiceImpl {

    // In-memory storage (for study purpose)
    private final List<InvestorProfile> investors = new ArrayList<>();

    // ✅ CREATE
    public InvestorProfile createInvestor(InvestorProfile investor) {
        investors.add(investor);
        return investor;
    }

    // ✅ GET BY ID
    public InvestorProfile getInvestorById(Long id) {
        Optional<InvestorProfile> result = investors.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();

        return result.orElse(null);
    }

    // ✅ GET ALL
    public List<InvestorProfile> getAllInvestors() {
        return investors;
    }
}
