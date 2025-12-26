package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.impl.InvestorProfileServiceImpl;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileServiceImpl service;

    @Autowired
    public InvestorProfileController(InvestorProfileServiceImpl service) {
        this.service = service;
    }

    // Create a new investor
    @PostMapping
    public ResponseEntity<InvestorProfile> createInvestor(@RequestBody InvestorProfile investor) {
        InvestorProfile created = service.createInvestor(investor);
        return ResponseEntity.ok(created);
    }

    // Get investor by ID
    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getInvestorById(@PathVariable Long id) {
        return service.getInvestorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all investors
    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAllInvestors() {
        List<InvestorProfile> investors = service.getAllInvestors();
        return ResponseEntity.ok(investors);
    }
}
