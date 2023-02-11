package com.example.insurance_component.Beneficiary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeneficiaryController {
    private final BeneficiaryService beneficiaryService;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService){
        this.beneficiaryService = beneficiaryService;
    }

    @GetMapping("/beneficiary/{id}")
    public List<Beneficiary> getBeneficiaries(){
        return BeneficiaryService.getBeneficiaries();
    }

    @PostMapping("/beneficiary/{id}")
    public void registerNewBeneficiary(@RequestBody Beneficiary beneficiary){
        beneficiaryService.addBeneficiary(beneficiary);
    }

    @DeleteMapping(path = "/beneficiary/{id}")
    public void deleteBeneficiary(@PathVariable("id") Long id){
        beneficiaryService.deleteBeneficiary(id);
    }

    @PutMapping("/beneficiary/{id}")
    public Beneficiary updateBeneficiary(Long id, Beneficiary beneficiary) throws Exception {
        return beneficiaryService.updateBeneficiary(id, beneficiary);
    }
}
