package com.example.demo.service.impl;



@Service 
public class InvestorProfileServiceImpl implements InvestorProfileService{

    @Autowired InvestorProfileRepository Investor;
    @Override 
    public InvestorProfile createInvestor(InvestorProfile investor){
        return Investor.save(investor);
    }
    public getInvestorById(Long id)

}