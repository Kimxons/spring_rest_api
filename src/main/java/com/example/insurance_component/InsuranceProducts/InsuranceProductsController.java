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

import com.example.insurance_component.NextOfKin.NextOfKin;
import com.example.insurance_component.NextOfKin.NextOfKinService;

public class InsuranceProductsController {
    private final InsuranceProductsService insuranceProductsService;
    
    @Autowired
    public InsuranceProductsController(InsuranceProductsService insuranceProductsService){
        this.insuranceProductsService = insuranceProductsService;
    }
    @GetMapping
    public List<NextOfKin> getNextOfKin(){
        return NextOfKinService.getNextOfKin();
    }

    @PostMapping
    public void registerInsuranceProduct(@RequestBody InsuranceProducts insuranceProducts){
        insuranceProductsService.addInsuranceProduct(insuranceProducts);
    }

    @DeleteMapping(path = "{id}")
    public void deleteInsuranceProduct(@PathVariable("id") Long id){
        insuranceProductsService.deleteInsuranceProduct(id);
    }
    
    @PutMapping(path = "{id}")
    public void updateInsuranceProduct(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String productType
    ){
        insuranceProductsService.updateInsuranceProduct(id, productType);
    }
}
