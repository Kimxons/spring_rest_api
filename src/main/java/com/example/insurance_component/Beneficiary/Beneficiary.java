package com.example.insurance_component.Beneficiary;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary_tbl", schema = "BENEFICIARIES")
public class Beneficiary {
    @Id
    @SequenceGenerator(name = "BENEFICIARY_SEQ", allocationSize = 25)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BENEFICIARY_GEN")
    @Column(name = "BENEFICIARY_ID")
    Long id;

    private static String b_name;
    private String b_phoneNumber;

    public Beneficiary() {
        //
    }

    // constructor
    public Beneficiary(Long b_id, String b_name, String b_phoneNumber) {
        this.id = b_id;
        Beneficiary.b_name = b_name;
        this.b_phoneNumber = b_phoneNumber;
    }

    // Getter and setter methods
    public void setB_id(Long b_id) {
        this.id = b_id;
    }

    public static String getB_Name() {
        return b_name;
    }

    public void setB_Name(String b_name) {
        Beneficiary.b_name = b_name;
    }

    public String getB_PhoneNumber() {
        return this.b_phoneNumber;
    }

    public void setB_PhoneNumber(String b_phoneNumber) {
        this.b_phoneNumber = b_phoneNumber;
    }
}