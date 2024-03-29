package com.maxback.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
	
	File profilePhoto;
	
	/**
	 * 
	 * @param customerId
	 * @param file
	 * @param userDetails
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/customer-profile/profile-image/{customer_id}")
	public File uploadProfileImg(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) throws IOException {
		profilePhoto = convertMultiPartToFile(file);
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().setProfileImageUrl(fileKey);
		customers.save(me.get());
		return profilePhoto;
	}
	
	/**
	 * 
	 * @param customerId
	 * @param userDetails
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/customer-profile/profile-image/{customer_id}")
	public File getProfileImg(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) throws IOException {
		Customer me = customers.findById(customerId).get();
		String fileKey = me.getUserFiles().getProfileImageUrl();
		File file = amazonClient.downloadFileFromS3(fileKey);
		//return amazonClient.getFileUrl(fileKey);
		return profilePhoto;
	}
	
	/**
	 * 
	 * @param customerId
	 * @param file
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/customer-profile/customer/recipts/{customer_id}")
	public Customer uploadRecipts(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().addRecipt(fileKey);
		return customers.save(me.get());
	}
	
	/**
	 * 
	 * @param customerId
	 * @param userDetails
	 * @return 
	 */
	@GetMapping("/customer-profile/customer/recipts/{customer_id}")
	public List<URL> getCustomerInsurance(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Customer me = customers.findById(customerId).get();
		List<String> fileKeys = me.getUserFiles().getRecipts();
		List<URL> urls = new ArrayList<URL>();
		fileKeys.stream().forEach((fileKey) -> {
			urls.add(amazonClient.getFileUrl(fileKey));
		});
		return urls;
	}
	
	/**
	 * 
	 * @param customerId
	 * @param file
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/customer-profile/customer/insurance/{customer_id}")
	public Customer uploadInsurance(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().addInsurance(fileKey);
		return customers.save(me.get());
	}
	
	/**
	 * 
	 * @param customerId
	 * @param userDetails
	 * @return 
	 */
	@GetMapping("/customer-profile/customer/insurance/{customer_id}")
	public List<URL> getCustomerReciepts(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Customer me = customers.findById(customerId).get();
		List<String> fileKeys = me.getUserFiles().getRecipts();
		List<URL> urls = new ArrayList<URL>();
		fileKeys.stream().forEach((fileKey) -> {
			urls.add(amazonClient.getFileUrl(fileKey));
		});
		return urls;
	}
	
	/**
	 * 
	 * @param customerId
	 * @param file
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/customer-profile/customer/license/{customer_id}")
	public Customer uploadLicense(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().addLicense(fileKey);
		return customers.save(me.get());
	}
	
	/**
	 * 
	 * @param customerId
	 * @param userDetails
	 * @return 
	 */
	@GetMapping("/customer-profile/customer/license/{customer_id}")
	public List<URL> getCustomerLicense(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Customer me = customers.findById(customerId).get();
		List<String> fileKeys = me.getUserFiles().getLicense();
		List<URL> urls = new ArrayList<URL>();
		fileKeys.stream().forEach((fileKey) -> {
			urls.add(amazonClient.getFileUrl(fileKey));
		});
		return urls;
	}
	
	/**
	 * 
	 * @param customerId
	 * @param file
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/customer-profile/customer/other/{customer_id}")
	public Customer uploadOther(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().addOther(fileKey);
		return customers.save(me.get());
	}
	
	/**
	 * 
	 * @param customerId
	 * @param userDetails
	 * @return 
	 */
	@GetMapping("/customer-profile/customer/other/{customer_id}")
	public List<URL> getCustomerOther(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Customer me = customers.findById(customerId).get();
		List<String> fileKeys = me.getUserFiles().getOther();
		List<URL> urls = new ArrayList<URL>();
		fileKeys.stream().forEach((fileKey) -> {
			urls.add(amazonClient.getFileUrl(fileKey));
		});
		return urls;
	}
	
	/**
	 * 
	 * @param customerId
	 * @param file
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/customer-profile/customer/w2/{customer_id}")
	public Customer uploadw2(@PathVariable(name = "customer_id") Long customerId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String fileKey = this.amazonClient.uploadFile(file);
		Optional<Customer> me = customers.findById(customerId);
		me.get().getUserFiles().addW2Forms(fileKey);
		return customers.save(me.get());
	}
	
	/**
	 * 
	 * @param customerId
	 * @param userDetails
	 * @return 
	 */
	@GetMapping("/customer-profile/customer/w2/{customer_id}")
	public List<URL> getCustomerW2(@PathVariable(name = "customer_id") Long customerId, @AuthenticationPrincipal UserDetails userDetails) {
		Customer me = customers.findById(customerId).get();
		List<String> fileKeys = me.getUserFiles().getW2Forms();
		List<URL> urls = new ArrayList<URL>();
		fileKeys.stream().forEach((fileKey) -> {
			urls.add(amazonClient.getFileUrl(fileKey));
		});
		return urls;
	}
	/**
	 * Employee files
	 */
	
	/**
	 * 
	 * @param employeeId
	 * @param file
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/employee-profile/profile-image/{employee_id}")
	public String uploadEmployeeProfileImg(@PathVariable(name = "employee_id") Long employeeId, @RequestPart(value = "file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) {
		String link = this.amazonClient.uploadFile(file);
		Optional<Employee> me = employees.findById(employeeId);
		me.get().setProfileImageUrl(link);
		employees.save(me.get());
		return link;
	}
	
	/**
	 * 
	 * @param employeeId
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/employee-profile/profile-image/{employee_id}")
	public String getEmployeeProfileImg(@PathVariable(name = "employee_id") Long employeeId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Employee> me = employees.findById(employeeId);
		return me.get().getProfileImageUrl();
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}