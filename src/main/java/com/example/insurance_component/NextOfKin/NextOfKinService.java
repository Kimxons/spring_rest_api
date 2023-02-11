package com.example.insurance_component.NextOfKin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class NextOfKinService {

    private final NextOfKinRepository nextOfKinRepository;

    @Autowired
    public NextOfKinService(NextOfKinRepository nextOfKinRepository) {
        this.nextOfKinRepository = nextOfKinRepository;
    }

    public Optional<NextOfKin> getNextOfKin() {
        return nextOfKinRepository.findById(null);
    }

    public NextOfKin createNextOfKin(NextOfKin nextOfKin) {
        return nextOfKinRepository.save(nextOfKin);
    }

    @Transactional
    public NextOfKin updateNextOfKin(Long id, NextOfKin nextOfKin) throws Exception {
        Optional<NextOfKin> existingNextOfKinOptional = nextOfKinRepository.findById(id);
        if (!existingNextOfKinOptional.isPresent()) {
            throw new Exception("Next of kin not found with id " + id);
        }
        NextOfKin existingNextOfKin = existingNextOfKinOptional.get();
        existingNextOfKin.setName(nextOfKin.getName());
        existingNextOfKin.setRelationships(nextOfKin.getRelationships());
        return nextOfKinRepository.save(existingNextOfKin);
    }

    public void deleteNextOfKin(Long id) {
        boolean exists = nextOfKinRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                "Record for Next of Kin with id" + id + "does not exist"
            );
        }
        nextOfKinRepository.deleteById(id);
    }

    public NextOfKin findNextOfKinById(Long id) {
        return null;
    }
}