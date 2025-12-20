package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpsRepository;
import org.springframework.sterotype.Repository;
import com.example.demo.entity.InvestorProfile;

@Repository
public interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long>{

}