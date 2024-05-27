package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.example.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee,Long> {
    
    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.name = :newName WHERE e.id = :id")
    void updateEmployeeNameById(Long id, String newName);

    @Query("SELECT e.id FROM Employee e")
    List<Long> findAllId();
}
