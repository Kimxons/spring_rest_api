package com.example.insurance_component;

public class Beneficiary {
    private String name;
    private String phoneNumber;

    public Beneficiary(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name; 
    }

    public String phoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}