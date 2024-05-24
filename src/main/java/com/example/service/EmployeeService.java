package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.EmployeeNotFoundException;
import com.example.exception.NullObject;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee savEmployeeData(Employee employeeEntity){
        if(employeeEntity==null){
            throw new NullObject("The value of obj is null");
        }
        return employeeRepository.save(employeeEntity);
    }

    public Employee updateEmployee(Long id ,String newName){
        if(id==0){
            throw new EmployeeNotFoundException("Id "+ id +" is not present in db");
        }
       return employeeRepository.updateEmployeeNameById(id, newName);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        if(id==0){
            throw new EmployeeNotFoundException("Id "+ id +" is not present in db");
        }
        employeeRepository.deleteById(id);
    }

}