package com.maxback.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.maxback.models.Customer;
import com.maxback.models.Employee;
import com.maxback.models.UserFiles;
import com.maxback.repositories.CustomerRepository;
import com.maxback.repositories.EmployeeRepository;
import com.maxback.services.AmazonClient;


@RestController
@RequestMapping("/files")
public class AwsFileController {

	@Autowired
	private AmazonClient amazonClient;
	@Autowired
	private CustomerRepository customers;
	@Autowired
	private EmployeeRepository employees;
	
	private static Logger log = LoggerFactory.getLogger(AmazonClient.class);

	@PostMapping("/customer-profile/profile-image/{customer_id}")
	public Customer uploadProfileImg(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().setProfileImageUrl(fileKey);
		return customers.save(me.get());
	}
	
	@GetMapping("/customer-profile/profile-image/{customer_id}")
	public URL getProfileImg(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) throws IOException {
		Customer me = customers.findById(customerId).orElseThrow();
		String fileKey = me.getUserFiles().getProfileImageUrl();
		File file = amazonClient.downloadFileFromS3(fileKey);
		return amazonClient.getFileUrl(fileKey);
	}
	
	@PostMapping("/employee-profile/profile-image/{employee_id}")
	public String uploadEmployeeProfileImg(@PathVariable(name = "employee_id") Long employeeId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String link = this.amazonClient.uploadFile(file);
		Optional<Employee> me = employees.findById(employeeId);
		me.get().setProfileImageUrl(link);
		employees.save(me.get());
		return link;
	}
	
	@GetMapping("/employee-profile/profile-image/{employee_id}")
	public String getEmployeeProfileImg(@PathVariable(name = "employee_id") Long employeeId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Employee> me = employees.findById(employeeId);
		return me.get().getProfileImageUrl();
	}
}