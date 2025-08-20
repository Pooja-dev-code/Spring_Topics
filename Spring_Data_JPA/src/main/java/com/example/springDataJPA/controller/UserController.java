package com.example.springDataJPA.controller;

import com.example.springDataJPA.dto.UserDTO;
import com.example.springDataJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        UserDTO saveUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(saveUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int userId){
        UserDTO userDTO = userService.getByUserID(userId);
        return ResponseEntity.ok(userDTO);
    }
}
