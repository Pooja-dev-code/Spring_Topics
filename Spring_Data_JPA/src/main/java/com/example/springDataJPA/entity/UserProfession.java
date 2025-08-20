package com.example.springDataJPA.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfession {

    @Id
    private int id;
    private String engineer;
    private String biodata;

    @OneToOne(mappedBy = "userProfession")
    @JsonBackReference
    private UserDetails userDetails;

}
