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

import com.maxback.models.Customer;
import com.maxback.models.Session;
import com.maxback.models.UserFiles;
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
	
	@PostMapping("/customer/new")
	public Customer createProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Customer newCustomer) {
		Customer customer = new Customer();
		UserFiles files = new UserFiles();
		files.setCustomer(customer);
		customer.setUserFiles(files);
		customer.setUsername(userDetails.getUsername());
		customer.setEmail(newCustomer.getEmail());
		customer.setAddress(newCustomer.getAddress());
		customer.setPhone(newCustomer.getPhone());
		customers.save(customer);
		return customer;
	}
	
	//@PostMapping("/customer/info")
	//public Customer setCustomerInfo(@AuthenticationPrincipal UserDetails userDetails) {
		//email
		//contact num
		//address
		//full name
	//}
	@GetMapping("/customer/{customer_id}")
	public Customer getProfile(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Customer> myProfile = customers.findById(customerId);
		return myProfile.get();
	}
	
	@DeleteMapping("/customer/{customer_id}")
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
