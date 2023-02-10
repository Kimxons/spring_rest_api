package com.example.insurance_component.InsuranceProducts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceProductsRepository extends JpaRepository<InsuranceProducts, Long> {
    Optional<InsuranceProducts> findInsuranceProductById(long id);
}
