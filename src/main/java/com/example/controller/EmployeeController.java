package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;
    
    @PostMapping("/employee")
    public Employee saveEmployeeData(@RequestBody Employee employeeEntity){
        return employeeService.savEmployeeData(employeeEntity);
    }


    @PutMapping("/employee")
    public Employee updateEmployee(@RequestParam("id") Long id,@RequestParam("newName") String newName){
        return employeeService.updateEmployee(id, newName);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/employee")
    public void deleteEmpoyee(@RequestParam("id") Long id){
        employeeService.deleteEmployee(id);
    }


    

}
