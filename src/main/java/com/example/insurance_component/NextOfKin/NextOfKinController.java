package com.example.insurance_component.NextOfKin;

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
public class NextOfKinController {

    private final NextOfKinService nextOfKinService;
    
    @Autowired
    public NextOfKinController(NextOfKinService nextOfKinService){
        this.nextOfKinService = nextOfKinService;
    }
    @GetMapping
    public List<NextOfKin> getNextOfKin(){
        return NextOfKinService.getNextOfKin();
    }

    @PostMapping
    public void registerNextOfKin(@RequestBody NextOfKin nextOfKin){
        nextOfKinService.addNextOfKin(nextOfKin);
    }

    @DeleteMapping(path = "{id}")
    public void deleteNextOfKin(@PathVariable("id") Long id){
        nextOfKinService.deleteNextOfKin(id);
    }
    
    @PutMapping(path = "{id}")
    public void updateBeneficiary(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String b_name,
        @RequestParam(required = false) String b_phoneNumber
    ){
        nextOfKinService.updateNexofKin(id, b_name, b_phoneNumber);
    }
}
