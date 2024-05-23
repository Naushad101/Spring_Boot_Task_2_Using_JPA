package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeCrudService;
@RestController
public class EmployeeCrudController {
    
    @Autowired
    EmployeeCrudService employeeCrudService;

    @PostMapping("/employeeCrud")
    public ResponseEntity<Employee> saveEmployeeData(@RequestBody Employee employeeEntity){
        return employeeCrudService.savEmployeeData(employeeEntity);
    }


    @PutMapping("/employeeCrud")
    public ResponseEntity<Void> updateEmployee(@RequestParam("id") Long id,@RequestParam("newName") String newName){
        return employeeCrudService.updateEmployee(id, newName);
    }


    @GetMapping("/employeeCrud")
    public ResponseEntity<Iterable<Employee>> getAllEmployee(){
        return employeeCrudService.getAllEmployee();
    }

    @DeleteMapping("/employeeCrud")
    public ResponseEntity<Void> deleteEmpoyee(@RequestParam("id") Long id){
       return employeeCrudService.deleteEmployee(id);
    }

    
}
