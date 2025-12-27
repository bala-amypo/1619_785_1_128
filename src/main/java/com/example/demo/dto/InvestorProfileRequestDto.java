package com.example.demo.dto;

public class InvestorProfileRequestDto {

    private String investorName;
    private String riskProfile;

    public InvestorProfileRequestDto() {
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
