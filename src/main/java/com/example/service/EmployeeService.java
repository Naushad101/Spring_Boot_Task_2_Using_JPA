package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee savEmployeeData(Employee employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public void updateEmployee(Long id ,String newName){
        employeeRepository.updateEmployeeNameById(id, newName);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
