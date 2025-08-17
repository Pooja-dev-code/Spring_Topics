package com.example.springDataJPA.service;

import com.example.springDataJPA.dto.UserDTO;
import com.example.springDataJPA.entity.UserDetails;
import com.example.springDataJPA.mapper.UserMapper;
import com.example.springDataJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO saveUser(UserDTO userDTO){
        UserDetails entity = userMapper.toEntity(userDTO);
        UserDetails saveEntity = userRepository.save(entity);
        return userMapper.toDTO(saveEntity);

    }
}
