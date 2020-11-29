package com.maxback.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxback.models.Employee;
import com.maxback.models.Session;
import com.maxback.repositories.EmployeeRepository;
import com.maxback.repositories.SessionRepository;
import com.maxback.services.VideoStreamingService;
import com.opentok.exception.OpenTokException;

@RestController
@RequestMapping("/employee-api/")
public class EmployeeController {

	@Autowired
	private VideoStreamingService videoStream;
	
	@Autowired
	private EmployeeRepository employees;
	
	@Autowired
	private SessionRepository sessions;
	
	@PostMapping("/employee/new")
	public Employee newEmployee(@RequestBody Employee employee, @AuthenticationPrincipal UserDetails userDetails) {
		Employee me = new Employee();
		me.setUsername(userDetails.getUsername());
		return employees.save(me);
	}
	
	@GetMapping("/employee/{employee_id}")
	public Employee getEmployeeById(@PathVariable(name = "employee_id") Long employeeId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Employee> me = employees.findById(employeeId);
		return me.get();
	}
	
	@DeleteMapping("/employee/{employee_id}")
	public String deleteProfile(@PathVariable(name = "employee_id") Long employeeId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Employee> me = employees.findById(employeeId);
		if (userDetails.getUsername().equals(me.get().getUsername())) {
			employees.deleteById(employeeId);	
			return "Employee deleted";
		}
		else return "Employee not deleted";
	}
	
	@GetMapping("/employee/token")
	public String getToken(@AuthenticationPrincipal UserDetails userDetails) throws OpenTokException {
		Long employeeId = employees.findByUsername(userDetails.getUsername()).get().getEmployeeId();
		Optional<Session> mySession = sessions.findByEmployeeId(employeeId);
		String token = videoStream.createToken(mySession.get().getOpenTokSessionId());
		return token;
	}
}
