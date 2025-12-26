package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.InvestorProfile;

@Repository
public interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long> {
    // Custom queries can be added here if needed
}
