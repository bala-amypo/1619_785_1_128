package com.example.demo.controller;

import com.example.demo.service.InvestorProfileService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public InvestorProfile rajdata(@PathVariable String investorId){
        return pservice.findByInvestorId(String investorId)
    }
    @GetMapping("/getAllInvestor")
    public List<InvestorProfile> baldata(){
        return pservice.getAllInvestor();
    }
    @PutMapping("/update/{id}")
    public  InvestorProfile asudata(@PathVariable Long id ,@RequestParam boolean active){
        return pservice.updateInvestorStatus(id,active);
    }

}
