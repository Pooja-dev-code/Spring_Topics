package com.example.springDataJPA.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserAddressCK {

    private String street;
    private String pincode;

    public UserAddressCK() {
    }

    public UserAddressCK(String street, String pincode) {
        this.street = street;
        this.pincode = pincode;
    }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
}
