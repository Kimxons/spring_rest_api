package com.example.insurance_component.Client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
 
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> getClientById(@PathVariable(value = "id") Long id){
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public Client updaClient(@PathVariable Long id, @RequestBody Client client) throws Exception {
        return clientService.updateClient(id, client);
    }

}
