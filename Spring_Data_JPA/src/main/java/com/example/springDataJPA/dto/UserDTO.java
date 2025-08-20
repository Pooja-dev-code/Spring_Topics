package com.example.springDataJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int user_id;
    private String user_name;
    private String user_age;

    private String street;
    private String pincode;
    private String name;
    private String phone;

    private String engineer;
    private String biodata;


}

