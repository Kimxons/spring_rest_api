package com.example.insurance_component.NextOfKin;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;

public class NextOfKinService {
    // public static Object addNextOfKinnnextOfKin;
    private static NextOfKinRepository nextOfKinRepository; 

    @Autowired
    public NextOfKinService(NextOfKinRepository nextOfKinRepository) {
        NextOfKinService.nextOfKinRepository = nextOfKinRepository;
    }
    public static List<NextOfKin> getNextOfKin() {
        return nextOfKinRepository.findAll();
    }
    public void addNextOfKin(NextOfKin nextOfKin){
        Optional<NextOfKin> nextOfKinOptional;
        nextOfKinOptional = nextOfKinRepository.findNextOfKinById(NextOfKin.getK_name());
        if(nextOfKinOptional.isPresent()){
            throw new IllegalStateException("Next of kin record already available!");
        }
        nextOfKinRepository.save(nextOfKin);
    }
    public void deleteNextOfKin(Long id){
        boolean exists = nextOfKinRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                "Record for Next of Kin with id" + id + "does not exist"
            );
        }
        nextOfKinRepository.deleteById(id);
    }

    @Transactional
    public void updateNexofKin(Long id, String k_name, String k_contact){
        NextOfKin nextOfKin = nextOfKinRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException(
            "Record for Next of Kin with id" + id + "does not exist"
        ));
        if (k_name != null && k_name.length() > 0 && !Objects.equals(NextOfKin.getK_name(), k_name)){
            nextOfKin.setK_name(k_name);
        }
        if(k_contact != null && k_contact.length() > 0 && !Objects.equals(k_contact, nextOfKin)){
            nextOfKin.setK_contact(k_contact);
        }
    }
}
