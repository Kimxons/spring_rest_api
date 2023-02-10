package com.example.insurance_component.Client;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.insurance_component.Beneficiary.Beneficiary;
import com.example.insurance_component.InsuranceProducts.InsuranceProducts;
import com.example.insurance_component.NextOfKin.NextOfKin;

import jakarta.transaction.Transactional;

public class ClientService {
    private static ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        ClientService.clientRepository = clientRepository;
    }

    public static List<Client> getClient() {
        return clientRepository.findAll();
    }

    public void addClient(Client client){
        Optional<Client> clientOptional;
        clientOptional = clientRepository.findClientById(Client.getClientId());
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
    public void updateClient(Long id,String firstName, String lastName, String otherNames, String phoneNumber,String email,
    List<InsuranceProducts> insuranceProducts, List<NextOfKin> nextOfKins, List<Beneficiary> beneficiaries){
        Client client = clientRepository.findClientById(id)
        .orElseThrow(() -> new IllegalStateException(
            "Record for Client with id" + id + "does not exist"
        ));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(Client.getFirstName(), firstName)){
            client.setFirstName(firstName);
        }
    }
}
