package com.example.springDataJPA.service;

import com.example.springDataJPA.dto.UserDTO;
import com.example.springDataJPA.entity.UserDetails;
import com.example.springDataJPA.mapper.UserMapper;
import com.example.springDataJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        //3. return DTO to client
        return userDTO;


    }
}
