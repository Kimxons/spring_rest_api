package com.example.insurance_component.NextOfKin;

import jakarta.persistence.*;

@Entity
@Table(name = "n_kin_tbl", schema = "KIN")
public class NextOfKin {
    @Id
    @SequenceGenerator(name = "KIN_SEQ", allocationSize = 25)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "KIN_GEN")
    @Column(name = "KIN_ID")
    Long id;

    private String k_name;
    private String k_contact;

    // Constructor
    public NextOfKin(long k_id, String k_name, String k_contact) {
        this.id = k_id;
        this.k_name = k_name;
        this.k_contact = k_contact;
    }

    // Getters and Setters
    public long getK_id() {
        return id;
    }

    public void setK_id(long k_id) {
        this.id = k_id;
    }

    // public static String getK_name() {
    //     return k_name;
    // }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }

    public String getK_contact() {
        return k_contact;
    }

    public void setK_contact(String k_contact) {
        this.k_contact = k_contact;
    }

    public static Long getK_name() {
        return null;
    }
}