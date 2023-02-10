package com.example.insurance_component.Client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findClientById(Long id);
}
