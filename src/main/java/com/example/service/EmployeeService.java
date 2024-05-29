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
        log.info("Employee ",employeeEntity,"is successfully saved in db");
        return employeeRepository.save(employeeEntity);
    }

    public void updateEmployee(Long id ,String newName){
        System.out.println("Udating....");
        if(!employeeRepository.findAllId().contains(id)){
            throw new EmployeeNotFoundException("Id "+ id +" is not present in db");
        }
       log.info("Employee with id ",id," is successfully updated");
        employeeRepository.updateEmployeeNameById(id, newName);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        if(!employeeRepository.findAllId().contains(id)){
            throw new EmployeeNotFoundException("Id "+ id +" is not present in db");
        }
        log.info("Employee with id ",id," is successfully deleted");
        employeeRepository.deleteById(id);
    }

}