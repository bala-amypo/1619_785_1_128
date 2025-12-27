package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private boolean active;

    // REQUIRED: no-args constructor
    public InvestorProfile() {}

    // REQUIRED: constructor used by tests
    public InvestorProfile(String firstName, String lastName, String email, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
    }

    // REQUIRED by tests
    public Long getId() {
        return id;
    }

    // REQUIRED by tests
    public void setId(Long id) {
        this.id = id;
    }

    // REQUIRED by tests
    public boolean getActive() {
        return active;
    }

    // REQUIRED by tests
    public void setActive(boolean active) {
        this.active = active;
    }

    // REQUIRED by tests
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Optional but safe
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
