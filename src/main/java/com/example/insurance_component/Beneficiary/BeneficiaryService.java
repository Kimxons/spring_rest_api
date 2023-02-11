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

    public void addBeneficiary(Beneficiary beneficiary){
        Optional<Beneficiary> beneficiaryOptional;
        beneficiaryOptional = beneficiaryRepository.findBeneficiaryByName(Beneficiary.getName());
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
    public Beneficiary updateBeneficiary(Long id, Beneficiary beneficiary) throws Exception{
        Optional<Beneficiary> existingBeneficiaryOptional = beneficiaryRepository.findById(id);
        if (!existingBeneficiaryOptional.isPresent()){
            throw new Exception("Beneficiary with id: " + id + "not found");
        }

        Beneficiary existingBeneficiary =existingBeneficiaryOptional.get();
        Beneficiary.setName(Beneficiary.getName());
        existingBeneficiary.setPhoneNumber(beneficiary.getPhoneNumber());
        return beneficiaryRepository.save(existingBeneficiary);
    }
}
