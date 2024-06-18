package com.example.exception;

public class EmployeeNotFoundException extends RuntimeException {
    String msg;
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
