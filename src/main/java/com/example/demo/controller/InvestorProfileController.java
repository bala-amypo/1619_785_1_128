package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InvestorProfile> create(@RequestBody InvestorProfile profile) {
        return ResponseEntity.ok(service.createInvestor(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInvestorById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAll() {
        return ResponseEntity.ok(service.getAllInvestors());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteInvestor(id);
        return ResponseEntity.noContent().build();
    }
}
