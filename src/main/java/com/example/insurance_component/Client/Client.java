package com.example.insurance_component.Client;

import java.util.List;

import com.example.insurance_component.NextOfKin.NextOfKin;
import com.example.insurance_component.Beneficiary;
import com.example.insurance_component.InsuranceProducts.InsuranceProducts;

public class Client {
    private int ClientID;
    private String firstName;
    private String lastName;
    private String otherNames;
    private String phoneNumber;
    private String email;
    private List<InsuranceProducts> insuranceProducts;
    private List<NextOfKin> nextOfKins;
    private List<Beneficiary> beneficiaries;
    
    public Client(int clientID, String firstName, String lastName, String otherNames, String email, String phoneNumber){
        ClientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherNames = otherNames;
        this.email = email;
    }

    public List<Beneficiary> getBeneficiaries(){
        return this.beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries){
        this.beneficiaries = beneficiaries;
    }

    public List<InsuranceProducts> getInsuranceProducts() {
        return insuranceProducts;
    }

    public List<NextOfKin> getNextOfKin(){
        return nextOfKins;
    }

    public void setNextOfKin(List<NextOfKin> nextOfKins){
        this.nextOfKins = nextOfKins;
    }

    public void setInsuranceProducts(List<InsuranceProducts> insuranceProducts) {
        this.insuranceProducts = insuranceProducts;
    }

    public int getClientID(){
        return this.ClientID;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getOtherNames(){
        return this.otherNames;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setOtherNames(String otherNames){
        this.otherNames = otherNames;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
