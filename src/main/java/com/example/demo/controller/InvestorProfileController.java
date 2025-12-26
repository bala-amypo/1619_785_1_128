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

    private final InvestorProfileServiceImpl service;

    public InvestorProfileController(InvestorProfileServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InvestorProfile> create(@RequestBody InvestorProfile investor) {
        return new ResponseEntity<>(service.createInvestor(investor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInvestorById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAll() {
        return ResponseEntity.ok(service.getAllInvestors());
    }
}
