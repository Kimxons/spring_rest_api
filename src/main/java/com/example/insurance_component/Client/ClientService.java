package com.example.insurance_component.Client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;

public class ClientService {
    private static ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        ClientService.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addClient(Client client){
        Optional<Client> clientOptional;
        clientOptional = clientRepository.findClientById(null);
        if(clientOptional.isPresent()){
            throw new IllegalStateException("Client record already available!");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Long id){
        boolean exists = clientRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                "Record for Client with id" + id + "does not exist"
            );
        }
        clientRepository.deleteById(id);
    }

    @Transactional
    public Client updateClient(Long id, Client client) throws Exception {
        Optional<Client> existingClientOptional = clientRepository.findById(id);
        if (!existingClientOptional.isPresent()) {
            throw new Exception("Client not found with id " + id);
        }
        Client existingClient = existingClientOptional.get();
        existingClient.setName(Client.getName());
        existingClient.setPhoneNumber(Client.getPhoneNumber());
        existingClient.setBeneficiaries(null);
        existingClient.setEmail(null);
        existingClient.setInsuranceProducts(null);
        existingClient.setNextOfKins(null);
        return clientRepository.save(existingClient);
    }

    public List<Client> findAll() {
        return null;
    }

    public Optional<Client> findById(Long id) {
        return null;
    }

    public Client save(Client client) {
        return null;
    }
}
