package com.maxback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxback.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findById(Long employeeId);
	Optional<Employee> findByUsername(String username);
}
