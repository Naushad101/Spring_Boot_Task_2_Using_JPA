package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

import jakarta.transaction.Transactional;
import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.name = :newName WHERE e.id = :id")
    void updateEmployeeNameById(Long id, String newName);

    @Query("SELECT e.id FROM Employee e")
    List<Long> findAllId();
 }
