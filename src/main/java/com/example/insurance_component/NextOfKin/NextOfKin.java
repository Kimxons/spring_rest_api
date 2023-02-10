package com.example.insurance_component.NextOfKin;

public class NextOfKin {
    private String name;
    private String contact; 

    public NextOfKin(String name, String contact){
        this.name = name;
        this.contact = contact; 
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getContact(){
        return this.contact;
    }

    public void setContact(String contact){
        this.contact = contact;
    }
}