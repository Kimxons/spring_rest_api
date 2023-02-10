package com.example.insurance_component.Beneficiary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
    Optional<Beneficiary> findBeneficiaryById(Long id); // find by id
    Optional<Beneficiary> findBeneficiaryByName(String b_name); // find by name
}
