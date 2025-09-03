package com.spring.AOP.service;

import com.spring.AOP.entity.EmployeeEntity;
import com.spring.AOP.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeEntity saveEmployee(EmployeeEntity emp){
        return employeeRepo.save(emp);
    }

    public Optional<EmployeeEntity> getEmpByID(int empID){
       Optional<EmployeeEntity> emp = employeeRepo.findById(empID);
       return emp;
    }
}
