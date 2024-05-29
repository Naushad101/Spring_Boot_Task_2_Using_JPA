package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAop {


    @Around("execution(* com.example.service.EmployeeService.getAllEmployee())")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before executing getAllEmployee method");
        
        Object result = joinPoint.proceed();
        
        System.out.println("After executing getAllEmployee method");
        
        return result; 
    }

}
