package com.example.insurance_component.InsuranceProducts;

import jakarta.persistence.*;

@Entity
@Table(name = "products_tbl", schema = "PRODUCTS")
public class InsuranceProducts {
    @Id
    @SequenceGenerator(name = "PRODUCT_SEQ", allocationSize = 50)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PRODUCT_GEN")
    @Column(name = "PRODUCT_ID")
    Long id;

    private String ProductType;

    // Constructor
    public InsuranceProducts(Long p_id, String productType) {
        this.id = p_id;
        ProductType = productType;
    }

    // Getters and Setters
    public Long getP_id() {
        return id;
    }

    public void setP_id(Long p_id) {
        this.id = p_id;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }
}