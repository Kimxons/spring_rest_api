package com.example.insurance_component.InsuranceProducts;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;

public class InsuranceProductsService {
    private static InsuranceProductsRepository insuranceProductsRepository; 

    @Autowired
    public InsuranceProductsService(InsuranceProductsRepository insuranceProductsRepository) {
        InsuranceProductsService.insuranceProductsRepository = insuranceProductsRepository;
    }
    public static List<InsuranceProducts> getInsuranceProducts() {
        return insuranceProductsRepository.findAll();
    }
    public void addInsuranceProduct(InsuranceProducts insuranceProducts){
        Optional<InsuranceProducts> insuranceProductsOptional;
        insuranceProductsOptional = insuranceProductsRepository.findInsuranceProductById(InsuranceProducts.getP_id());
        if(insuranceProductsOptional.isPresent()){
            throw new IllegalStateException("Insurance Product Type record already available!");
        }
        insuranceProductsRepository.save(insuranceProducts);
    }
    public void deleteInsuranceProduct(Long id){
        boolean exists = insuranceProductsRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                "Record for id: " + id + "does not exist"
            );
        }
        insuranceProductsRepository.deleteById(id);
    }

    @Transactional
    public void updateInsuranceProduct(Long id, String ProductType){
        InsuranceProducts insuranceProducts = insuranceProductsRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException(
            "Record for id: " + id + "does not exist"
        ));
        if (ProductType != null && ProductType.length() > 0 && !Objects.equals(InsuranceProducts.getP_id(), id)){
            insuranceProducts.setProductType(ProductType);
        }
    }
}
