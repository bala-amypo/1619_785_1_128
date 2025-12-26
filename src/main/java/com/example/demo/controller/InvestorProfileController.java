package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.impl.InvestorProfileServiceImpl;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileServiceImpl investorService;

    public InvestorProfileController(InvestorProfileServiceImpl investorService) {
        this.investorService = investorService;
    }

    @PostMapping
    public ResponseEntity<InvestorProfile> createInvestor(
            @RequestBody InvestorProfile investor) {
        return new ResponseEntity<>(
                investorService.createInvestor(investor),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getInvestorById(@PathVariable Long id) {
        return ResponseEntity.ok(investorService.getInvestorById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAllInvestors() {
        return ResponseEntity.ok(investorService.getAllInvestors());
    }
}
