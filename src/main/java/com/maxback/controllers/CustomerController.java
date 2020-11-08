package com.maxback.controllers;

import java.util.List;
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

import com.maxback.models.Customer;
import com.maxback.models.Session;
import com.maxback.repositories.CustomerRepository;
import com.maxback.repositories.SessionRepository;
import com.maxback.services.VideoStreamingService;
import com.opentok.exception.OpenTokException;

@RestController
@RequestMapping("/profile-api/")
public class CustomerController {

	@Autowired
	private VideoStreamingService videoStream;
	
	@Autowired
	private SessionRepository sessions;
	
	@Autowired
	private CustomerRepository customers;
	
	@PostMapping("customer/new")
	public Customer createProfile(@RequestBody Customer customer, @AuthenticationPrincipal UserDetails userDetails) {
		Customer myProfile = new Customer();
		myProfile.setUsername(userDetails.getUsername());
		return customers.save(myProfile);
	}
	
	@GetMapping("/customer/{customer_id}")
	public Customer getProfile(@PathVariable(name = "profile_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Customer> myProfile = customers.findByUsername(userDetails.getUsername());
		return myProfile.get();
	}
	
	@DeleteMapping("/customer/{customer_id")
	public String deleteProfile(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		customers.deleteById(customerId);
		return "Account with id " + customerId + " has been deleted";
	}
	
	@GetMapping("/customer/token")
	public String getToken(@AuthenticationPrincipal UserDetails userDetails) throws OpenTokException {
		Long customerId = customers.findByUsername(userDetails.getUsername()).get().getCustomerId();
		Optional<Session> mySession = sessions.findByCustomerId(customerId);
		String token = videoStream.createToken(mySession.get().getOpenTokSessionId());
		return token;
	}
}
