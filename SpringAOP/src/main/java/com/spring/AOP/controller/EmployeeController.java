package com.spring.AOP.controller;

import com.spring.AOP.entity.EmployeeEntity;
import com.spring.AOP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity emp){
        EmployeeEntity employeeEntity = employeeService.saveEmployee(emp);
        return ResponseEntity.ok(employeeEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> getEmpByID(@PathVariable("id") int empID){
        Optional<EmployeeEntity> emp = employeeService.getEmpByID(empID);
        return ResponseEntity.ok(emp);
    }

}
