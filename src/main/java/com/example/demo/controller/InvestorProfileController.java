package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
@RequiredArgsConstructor
@Tag(name = "Investor Profile")
public class InvestorProfileController {

    private final InvestorProfileService investorProfileService;

    @PostMapping
    public InvestorProfile createInvestor(@RequestBody InvestorProfile investor) {
        return investorProfileService.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getInvestorById(@PathVariable Long id) {
        return investorProfileService.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAllInvestors() {
        return investorProfileService.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateStatus(@PathVariable Long id,
                                        @RequestParam boolean active) {
        return investorProfileService.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public InvestorProfile findByInvestorId(@PathVariable String investorId) {
        return investorProfileService.findByInvestorId(investorId);
    }
}
