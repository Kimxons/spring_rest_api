package com.example.insurance_component.Beneficiary;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private static String name;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Beneficiary.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Beneficiary() {
        //
    }

    // constructor
    public Beneficiary(Long id, String name, String phoneNumber) {
        this.id = id;
        Beneficiary.name = name;
        this.phoneNumber = phoneNumber;
    }
}