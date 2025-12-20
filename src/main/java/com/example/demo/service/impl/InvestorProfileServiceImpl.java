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
        return Investor.findById(id);
    }
    @Override
    public InvestorProfile findByInvestorId(String investorId){
        return Investor.findByInvestorId(investorId);
    }
    @Override 
    public List<InvestorProfile> getAllInvestor(){
        return Investor.findAll();
    }
    @Override 
    public InvestorProfile updateInvestorStatus(Long id,boolean active){
        return Investor.save(investor);
    }

}