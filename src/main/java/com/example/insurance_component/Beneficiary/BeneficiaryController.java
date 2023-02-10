package com.example.insurance_component.Beneficiary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeneficiaryController {
    private final BeneficiaryService beneficiaryService;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService){
        this.beneficiaryService = beneficiaryService;
    }

    @GetMapping
    public List<Beneficiary> getBeneficiaries(){
        return BeneficiaryService.getBeneficiaries();
    }

    @PostMapping
    public void registerNewBeneficiary(@RequestBody Beneficiary beneficiary){
        beneficiaryService.addBeneficiary(beneficiary);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBeneficiary(@PathVariable("id") Long id){
        beneficiaryService.deleteBeneficiary(id);
    }
    
    @PutMapping(path = "{id}")
    public void updateBeneficiary(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String b_name,
        @RequestParam(required = false) String b_phoneNumber
    ){
        beneficiaryService.updateBeneficiary(id, b_name, b_phoneNumber);
    }
}
