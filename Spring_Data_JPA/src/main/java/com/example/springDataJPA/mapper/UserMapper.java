package com.example.springDataJPA.mapper;

import com.example.springDataJPA.dto.UserDTO;
import com.example.springDataJPA.entity.UserAddress;
import com.example.springDataJPA.entity.UserAddressCK;
import com.example.springDataJPA.entity.UserDetails;
import com.example.springDataJPA.entity.UserProfession;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //when data needs to be fetched from database we need to convert entity to dto
    //Convert Entity -> DTO (Fetch from DB → Send to Client).
    public UserDTO toDTO(UserDetails userDetails){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(userDetails.getUser_id());
        userDTO.setUser_name(userDetails.getUserName());
        userDTO.setUser_age(userDetails.getUser_age());

        //Map address
        if(userDetails.getUserAddress() !=null){
            userDTO.setPhone(userDetails.getUserAddress().getPhone());
            userDTO.setName(userDetails.getUserAddress().getName());
            userDTO.setStreet(userDetails.getUserAddress().getUserAddressCK().getStreet());
            userDTO.setPincode(userDetails.getUserAddress().getUserAddressCK().getPincode());
        }

        //Map profession
        if(userDetails.getUserProfession() != null){
            userDTO.setEngineer(userDetails.getUserProfession().getEngineer());
            userDTO.setBiodata(userDetails.getUserProfession().getBiodata());
        }

        return userDTO;
    }

    // used when data needs to be stored in database we need to convert dto to entity
    // Convert DTO -> Entity (Client Request → Store in DB)
    public UserDetails toEntity(UserDTO userDTO){
        UserDetails userDetails = new UserDetails();
        userDetails.setUser_id(userDTO.getUser_id());
        userDetails.setUserName(userDTO.getUser_name());
        userDetails.setUser_age(userDTO.getUser_age());

        //store address in entity
        UserAddressCK userAddressCK =  new UserAddressCK(userDTO.getStreet(), userDTO.getPincode());
        UserAddress userAddress = new UserAddress(userDTO.getPhone(), userDTO.getName(),userAddressCK);
        userDetails.setUserAddress(userAddress);

        //store profession in entity
        UserProfession userProfession = new UserProfession();
        userProfession.setId(userDTO.getUser_id()); // using same id as UserDetails
        userProfession.setEngineer(userDTO.getEngineer());
        userProfession.setBiodata(userDTO.getBiodata());
        userProfession.setUserDetails(userDetails); // link back for bidirectional mapping

        userDetails.setUserProfession(userProfession);

        return userDetails;
    }
}
