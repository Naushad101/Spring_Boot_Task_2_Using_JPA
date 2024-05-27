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
import org.springframework.web.server.ResponseStatusException;

import com.example.exception.EmployeeNotFoundException;
import com.example.exception.GlobalException;
import com.example.exception.NullObject;
import com.example.model.Employee;
import com.example.repository.EmployeeCrudRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeCrudService {
   
    @Autowired
    EmployeeCrudRepository employeeCrudRepository;
    
    public ResponseEntity<Employee> savEmployeeData(Employee employeeEntity){
       if(employeeEntity==null){
         throw new NullObject("Object is null");
       }
       log.info("Employee",employeeEntity," is Successfully saved in db");
       Employee e= employeeCrudRepository.save(employeeEntity);
    return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateEmployee(Long id ,String newName){
      if(!employeeCrudRepository.findAllId().contains(id)){
         throw new EmployeeNotFoundException("Id is not present in db");
      }
      log.info("Employee with id ",id," is successfully updated");
       employeeCrudRepository.updateEmployeeNameById(id,newName);
       return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Iterable<Employee>> getAllEmployee(){
       Iterable<Employee> employees= employeeCrudRepository.findAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteEmployee(Long id){

         if(!employeeCrudRepository.findAllId().contains(id)){

           throw new EmployeeNotFoundException("Employee is not present in db");
   
         }

        log.info("Employee with "+ id + " is succesfully deleted");
        employeeCrudRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
