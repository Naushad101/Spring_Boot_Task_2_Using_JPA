package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Employee;
import com.example.repository.EmployeeCrudRepository;

@Service
public class EmployeeCrudService {
   
    @Autowired
    EmployeeCrudRepository employeeCrudRepository;
    
    public ResponseEntity<Employee> savEmployeeData(Employee employeeEntity){
       Employee e= employeeCrudRepository.save(employeeEntity);
    return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateEmployee(Long id ,String newName){
       employeeCrudRepository.updateEmployeeNameById(id,newName);
       return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Iterable<Employee>> getAllEmployee(){
       Iterable<Employee> employees= employeeCrudRepository.findAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteEmployee(Long id){
        employeeCrudRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
