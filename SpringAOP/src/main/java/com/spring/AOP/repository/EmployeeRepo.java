package com.spring.AOP.repository;

import com.spring.AOP.entity.EmployeeEntity;
import com.spring.AOP.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
