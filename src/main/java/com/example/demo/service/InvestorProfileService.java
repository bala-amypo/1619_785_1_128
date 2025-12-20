package com.example.demo.service;

import com.example.demo.entity.InvestorProfile;
import java.utill.List;

public interface InvestorProfileService{

    InvestorProfile createInvestor(InvestorProfile investor);
    InvestorProfile getInvestorById(Long id);
    InvestorProfile findByInvestorId(String investorId);
    List<InvestorProfile> getAllInvestor();
    InvestorProfile updateInvestorStatus(Long id,boolean active);

}