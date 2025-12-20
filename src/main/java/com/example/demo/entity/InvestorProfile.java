package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String investorId;
    private String fullName;
    private String email;
    private boolean active;
    private Date created;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvestorId() { return investorId; }
    public void setInvestorId(String investorId) { this.investorId = investorId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }

    public InvestorProfile(Long id, String investorID, String fullName,
                           String email, boolean active, Date created) {
        this.id = id;
        this.investorId = investorID;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
        this.created = created;
    }

    public InvestorProfile() {}
}
