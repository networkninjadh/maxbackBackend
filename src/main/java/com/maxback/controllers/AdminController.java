package com.maxback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxback.models.Customer;
import com.maxback.models.Employee;
import com.maxback.repositories.CustomerRepository;
import com.maxback.repositories.EmployeeRepository;

@RestController
@RequestMapping("/admin-api/")
public class AdminController {

	@Autowired
	private EmployeeRepository employees;
	@Autowired
	private CustomerRepository customers;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(@AuthenticationPrincipal UserDetails userDetails){
		return customers.findAll();
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(@AuthenticationPrincipal UserDetails userDetails){
		return employees.findAll();
	}
	
	//session management
	//get sessions
	//delete all sessions
	//delete session by id
	//delete session by employee

}
