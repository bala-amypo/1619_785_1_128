package com.example.demo.service.impl;



@Service 
public class InvestorProfileServiceImpl implements InvestorProfileService{

    @Autowired InvestorProfileRepository Investor;
    @Override 
    public InvestorProfile createInvestor(InvestorProfile investor){
        return Investor.save(investor);
    }
    @Override
    public List<InvestorProfile> getInvestorById(Long id){
        return Investor.findAll(id);
    }

}