package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestorProfileController {

    @Autowired
    private InvestorProfileService pservice;

    @PostMapping("/createInvestordata")
    public InvestorProfile maddata(@RequestBody InvestorProfile investor) {
        return pservice.createInvestor(investor);
    }

    @GetMapping("/getInvestorByIds/{id}")
    public InvestorProfile dandata(@PathVariable Long id) {
        return pservice.getInvestorById(id);
    }

    @GetMapping("/findByInvestorId/{investorId}")
    public InvestorProfile rajdata(@PathVariable String investorId) {
        return pservice.findByInvestorId(investorId);
    }

    @GetMapping("/getAllInvestor")
    public List<InvestorProfile> baldata() {
        return pservice.getAllInvestor();
    }

    @PutMapping("/update/{id}")
    public InvestorProfile asudata(@PathVariable Long id, @RequestParam boolean active) {
        return pservice.updateInvestorStatus(id, active);
    }
}
