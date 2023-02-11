package com.example.insurance_component.NextOfKin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nextofkin")
public class NextOfKinController {

    private final NextOfKinService nextOfKinService;
    
    @Autowired
    public NextOfKinController(NextOfKinService nextOfKinService){
        this.nextOfKinService = nextOfKinService;
    }

    @PostMapping("/{id}")
    public void registerNextOfKin(@RequestBody NextOfKin nextOfKin){
        nextOfKinService.createNextOfKin(nextOfKin);
    }

    @GetMapping("/{id}")
    public NextOfKin getNextOfKinById(@PathVariable Long id) {
        return nextOfKinService.findNextOfKinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNextOfKin(@PathVariable Long id) {
        nextOfKinService.deleteNextOfKin(id);
    }
    
    @PutMapping("/{id}")
    public NextOfKin updateNextOfKin(@PathVariable Long id, @RequestBody NextOfKin nextOfKin) throws Exception {
        return nextOfKinService.updateNextOfKin(id, nextOfKin);
    }
}