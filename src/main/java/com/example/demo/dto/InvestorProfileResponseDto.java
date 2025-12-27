package com.example.demo.dto;

public class InvestorProfileResponseDto {

    private Long id;
    private String investorName;
    private String riskProfile;

    public InvestorProfileResponseDto() {
    }

    public InvestorProfileResponseDto(Long id, String investorName, String riskProfile) {
        this.id = id;
        this.investorName = investorName;
        this.riskProfile = riskProfile;
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getInvestorName() {
        return investorName;
    }
 
    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }
 
    public String getRiskProfile() {
        return riskProfile;
    }
 
    public void setRiskProfile(String riskProfile) {
        this.riskProfile = riskProfile;
    }
}
