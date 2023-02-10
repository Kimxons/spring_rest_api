package com.example.insurance_component.InsuranceProducts;

public class InsuranceProducts {
    private int p_id;
    private String ProductType;

    public InsuranceProducts(int p_id, String productType) {
        this.p_id = p_id;
        ProductType = productType;
    }
    // Getter and Setter methods implementations
    public String getProductType(){
        return this.ProductType;
    }

    public void setProductType(String ProductType){
        this.ProductType = ProductType; 
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "InsuranceProducts [p_id=" + p_id + ", ProductType=" + ProductType + "]";
    }
}