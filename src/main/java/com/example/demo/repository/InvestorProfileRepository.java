package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileRepository {
    InvestorProfile save(InvestorProfile investor);
    Optional<InvestorProfile> findById(Long id);
    List<InvestorProfile> findAll();
    Optional<InvestorProfile> findByInvestorId(String investorId);
}
