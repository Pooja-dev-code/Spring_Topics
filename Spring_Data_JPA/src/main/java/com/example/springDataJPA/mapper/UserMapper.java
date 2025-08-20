package com.example.springDataJPA.mapper;

import com.example.springDataJPA.dto.UserDTO;
import com.example.springDataJPA.entity.UserAddress;
import com.example.springDataJPA.entity.UserAddressCK;
import com.example.springDataJPA.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //used when data needs to be send to client, so send via DTO form
    public UserDTO toDTO(UserDetails userDetails){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(userDetails.getUser_id());
        userDTO.setUser_name(userDetails.getUser_name());
        userDTO.setUser_age(userDetails.getUser_age());

        if(userDetails.getUserAddress() !=null){
            userDTO.setPhone(userDetails.getUserAddress().getPhone());
            userDTO.setName(userDetails.getUserAddress().getName());
            userDTO.setStreet(userDetails.getUserAddress().getUserAddressCK().getStreet());
            userDTO.setPincode(userDetails.getUserAddress().getUserAddressCK().getPincode());
        }
        return userDTO;
    }

    // used when data needs to be fetched from in database, so fetched via entity
    public UserDetails toEntity(UserDTO userDTO){
        UserDetails userDetails = new UserDetails();
        userDetails.setUser_id(userDTO.getUser_id());
        userDetails.setUser_name(userDTO.getUser_name());
        userDetails.setUser_age(userDTO.getUser_age());

        UserAddressCK userAddressCK =  new UserAddressCK(userDTO.getStreet(), userDTO.getPincode());
        UserAddress userAddress = new UserAddress(userDTO.getPhone(), userDTO.getName(),userAddressCK);
        userDetails.setUserAddress(userAddress);
        return userDetails;
    }
}
