package com.example.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.controller.EmployeeController;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import java.util.*;


public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void saveEmployeeDataTest(){
        Employee employee = new Employee(1L,"sam","Developer","BNT");
        when(employeeService.savEmployeeData(employee)).thenReturn(employee);
        Employee employee1=employeeController.saveEmployeeData(employee);
        assertEquals(employee, employee);
        
    }

    @Test
    public void updateEmployeeTest(){
        Employee employee = new Employee(1L,"sam","devloper","bnt");
        when(employeeService.updateEmployee(1L, "sam")).thenReturn(employee);
        Employee employee2 = employeeController.updateEmployee(1L, "sam");
        assertEquals(employee, employee2);
    }

    @Test
    public void getAllEmployee(){
        Employee e1 = new Employee(1L,"jayesh","Software Developer","BNT");
        Employee e2 = new Employee(2L,"vishal","Software Developer","BNT");
        Employee e3 = new Employee(3L,"sumer","Software Developer","BNT");
        Employee e4 = new Employee(4L,"supriya","Software Developer","BNT");
        Employee e5 = new Employee(5L,"ali","Software Developer","BNT");
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        when(employeeService.getAllEmployee()).thenReturn(employees);
        List<Employee> employees2 = employeeController.getAllEmployee();
        assertEquals(employees, employees2);
    }
}
