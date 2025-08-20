package com.example.springDataJPA.service;

import com.example.springDataJPA.dto.UserDTO;
import com.example.springDataJPA.entity.UserDetails;
import com.example.springDataJPA.mapper.UserMapper;
import com.example.springDataJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO saveUser(UserDTO userDTO){
        // 1. Convert the incoming DTO to an Entity, because JPA works with entities
        UserDetails entity = userMapper.toEntity(userDTO);
        // 2. Save the entity to the database
        UserDetails saveEntity = userRepository.save(entity);
        // 3. Convert the saved entity back to DTO to return to the client
        return userMapper.toDTO(saveEntity);
    }

    public UserDTO getByUserID(int userID){
        // 1. Fetch entity from the database
        UserDetails userDetails = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userID));
        //2. Convert entity to DTO
        UserDTO userDTO = userMapper.toDTO(userDetails);
        //3. return DTO response to client
        return userDTO;
    }

    public List<UserDTO> getUsersByName(String userName){
        //1.fetch all entities from the database
        List<UserDetails> userDetailsList = userRepository.findByUserName(userName);
        //2.convert each entity to DTO using loop and mapper
        //create a list to store entities in DTO
        List<UserDTO> userDTOList = new ArrayList<>();
        //using loop, convert each entity to DTO, to give response to the client
        for(UserDetails userDetails:  userDetailsList){
            userDTOList.add(userMapper.toDTO(userDetails));
        }
        //return DTO response
        return  userDTOList;
    }

    public List<UserDTO> getUsersByAge(String age){
        //1.fetch all enitites from the database
        List<UserDetails> userDetailsList = userRepository.findUserByAge(age);
        // 2. Convert each entity to DTO using UserMapper
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserDetails userDetails: userDetailsList){
            userDTOList.add(userMapper.toDTO(userDetails));
        }
        //return DTO response
        return userDTOList;
    }
}
