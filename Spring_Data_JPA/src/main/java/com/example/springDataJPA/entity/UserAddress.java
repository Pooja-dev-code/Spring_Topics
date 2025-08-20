package com.example.springDataJPA.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAddress {

    @EmbeddedId
    private UserAddressCK userAddressCK;

    private String name;
    private String phone;

    public UserAddress() {
    }

    public UserAddress(String name, String phone, UserAddressCK userAddressCK) {
        this.name = name;
        this.phone = phone;
        this.userAddressCK = userAddressCK;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public UserAddressCK getUserAddressCK() { return userAddressCK; }
    public void setUserAddressCK(UserAddressCK userAddressCK) { this.userAddressCK = userAddressCK; }
}
