package com.example.insurance_component.Beneficiary;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BeneficiaryService {
    private static BeneficiaryRepository beneficiaryRepository;

    @Autowired
    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        BeneficiaryService.beneficiaryRepository = beneficiaryRepository;
    }

    public static List<Beneficiary> getBeneficiaries() {
        return beneficiaryRepository.findAll();
    }

    // CRUD - Beneficiary
    public void addBeneficiary(Beneficiary beneficiary){
        Optional<Beneficiary> beneficiaryOptional;
        beneficiaryOptional = beneficiaryRepository.findBeneficiaryByName(Beneficiary.getB_Name());
        if(beneficiaryOptional.isPresent()){
            throw new IllegalStateException("Beneficiary record already available!");
        }
        beneficiaryRepository.save(beneficiary);
    }

    public void deleteBeneficiary(Long id){
        boolean exists = beneficiaryRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                "Record for Beneficiary with id" + id + "does not exist"
            );
        }
        beneficiaryRepository.deleteById(id);
    }

    @Transactional
    public void updateBeneficiary(Long id, String b_name, String b_phoneNumber){
        Beneficiary beneficiary = beneficiaryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException(
            "Record for Beneficiary with id" + id + "does not exist"
        ));
        if (b_name != null && b_name.length() > 0 && !Objects.equals(Beneficiary.getB_Name(), b_name)){
            beneficiary.setB_Name(b_name);
        }
        if(b_phoneNumber != null && b_phoneNumber.length() > 0 && !Objects.equals(b_phoneNumber, beneficiary)){
            beneficiary.setB_PhoneNumber(b_phoneNumber);
        }
    }
}
