package com.example.springDataJPA.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    private int user_id;
    private String userName;
    private String user_age;

    //this userAddress is for unidirectional mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "address_street", referencedColumnName = "street"),
            @JoinColumn(name = "address_pin_code", referencedColumnName = "pincode")
    })
    private UserAddress userAddress;

    //this userProfession is bidirectional mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profession_id" , referencedColumnName = "id")
    @JsonManagedReference
    private UserProfession userProfession;
}
