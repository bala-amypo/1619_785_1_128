package com.example.demo.controller;



@RestController
public class InvestorProfileController{

    @Autowired InvestorProfileService pservice;
    @PostMapping("/createInvestordata")
    public InvestorProfile maddata(@RequestBody InvestorProfile investor){
        return pservice.createInvestor(investor);
    }
    @GetMapping("/getInvestorByIds/{id}")
    public List<InvestorProfile> dandata(@PathVariable Long id){
        return pservice.getInvestorById(id);
    }
    @GetMapping("/findByInvestorId/{investorId}")
    public InvestorProfile rajdata(String investorId){
        return pservice.findByInvestorId()
    }
}