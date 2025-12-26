package com.example.demo.entity;

public class InvestorProfile {
    private Long id;
    private String investorId;
    private String fullName;
    private String email;
    private boolean active;

    public InvestorProfile(String investorId, String fullName, String email, boolean active) {
        this.investorId = investorId;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInvestorId() { return investorId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
