package com.example.springDataJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserDetails {

    @Id
    private int user_id;
    private String user_name;
    private String user_age;

    public UserDetails() {
    }

    public UserDetails(int user_id, String user_name, String user_age) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_age = user_age;
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

}
