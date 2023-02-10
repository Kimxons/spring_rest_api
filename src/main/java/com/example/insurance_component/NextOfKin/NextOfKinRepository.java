package com.example.insurance_component.NextOfKin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NextOfKinRepository extends JpaRepository<NextOfKin, Long>{
    Optional<NextOfKin> findNextOfKinById(Long id);
}
