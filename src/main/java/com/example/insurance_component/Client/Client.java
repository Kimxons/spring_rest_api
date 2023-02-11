package com.example.insurance_component.Client;

import java.util.ArrayList;
import java.util.List;

import com.example.insurance_component.Beneficiary.Beneficiary;
import com.example.insurance_component.InsuranceProducts.InsuranceProducts;
import com.example.insurance_component.NextOfKin.NextOfKin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    private static String name;
    private String email;
    private static String phoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<InsuranceProducts> insuranceProducts = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<NextOfKin> nextOfKins;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Beneficiary> beneficiaries;

    public void setId(Long id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        Client.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        Client.phoneNumber = phoneNumber;
    }

    public List<InsuranceProducts> getInsuranceProducts() {
        return insuranceProducts;
    }

    public void setInsuranceProducts(List<InsuranceProducts> insuranceProducts) {
        this.insuranceProducts = insuranceProducts;
    }

    public List<NextOfKin> getNextOfKins() {
        return nextOfKins;
    }

    public void setNextOfKins(List<NextOfKin> nextOfKins) {
        this.nextOfKins = nextOfKins;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Client(Long id, String name, String phoneNumber, String email, List<InsuranceProducts> insuranceProducts, List<NextOfKin> nextOfKins,
            List<Beneficiary> beneficiaries) {
        this.id = id;
        Client.name = name;
        this.email = email;
        Client.phoneNumber = phoneNumber;
        this.insuranceProducts = insuranceProducts;
        this.nextOfKins = nextOfKins;
        this.beneficiaries = beneficiaries;
    }
    
}