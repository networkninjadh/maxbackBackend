package com.maxback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.maxback.models.Customer;
import com.maxback.repositories.CustomerRepository;
import com.maxback.security.services.JwtUserDetailsService;

@RestController
@RequestMapping("/profile-api/")
public class UserController {

	@Autowired
	private JwtUserDetailsService users;
	
	@Autowired
	private CustomerRepository profiles;
	
	@PostMapping("customer/new")
	public Customer createProfile(@RequestBody Customer customer, @AuthenticationPrincipal UserDetails userDetails) {
		Customer myProfile = new Customer();
		myProfile.setUsername(userDetails.getUsername());
		return profiles.save(myProfile);
	}
	
	@GetMapping("/customer/{customer_id}")
	public Customer getProfile(@PathVariable(name = "profile_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Customer> myProfile = profiles.findByUsername(userDetails.getUsername());
		return myProfile.get();
	}
}
