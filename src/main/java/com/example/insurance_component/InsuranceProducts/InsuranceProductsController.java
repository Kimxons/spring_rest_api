package com.example.insurance_component.InsuranceProducts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class InsuranceProductsController {
    private final InsuranceProductsService insuranceProductsService;
    
    @Autowired
    public InsuranceProductsController(InsuranceProductsService insuranceProductsService){
        this.insuranceProductsService = insuranceProductsService;
    }
    @GetMapping("/products/{id}")
    public List<InsuranceProducts> getInsuranceProducts(){
        return InsuranceProductsService.getInsuranceProducts();
    }

    @PostMapping("/products/{id}")
    public void registerInsuranceProduct(@RequestBody InsuranceProducts insuranceProducts){
        insuranceProductsService.addInsuranceProduct(insuranceProducts);
    }

    @DeleteMapping("/products/{id}")
    public void deleteInsuranceProduct(@PathVariable("id") Long id){
        insuranceProductsService.deleteInsuranceProduct(id);
    }
    
    @PutMapping(path = "/products/{id}")
    public void updateInsuranceProduct(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String productType
    ){
        insuranceProductsService.updateInsuranceProduct(id, productType);
    }
}
