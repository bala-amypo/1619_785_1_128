package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileService service;

    @Autowired
    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile createInvestor(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getInvestorById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAllInvestors() {
        return service.getAllInvestors();
    }
}
