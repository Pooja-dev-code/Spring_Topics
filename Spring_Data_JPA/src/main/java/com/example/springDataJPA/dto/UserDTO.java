package com.example.springDataJPA.dto;

public class UserDTO {

    private int user_id;
    private String user_name;
    private String user_age;

    private String street;
    private String pincode;
    private String name;
    private String phone;

    public UserDTO() {
    }

    public UserDTO(int user_id, String user_name, String user_age, String street, String pincode, String name, String phone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_age = user_age;
        this.street = street;
        this.pincode = pincode;
        this.name = name;
        this.phone = phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

