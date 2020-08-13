package com.maxback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.maxback.models.User;
import com.maxback.repositories.UserRepository;

@Controller
public class WebController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@GetMapping("/services")
	public void servicesPage() {
		
	}
	
	@GetMapping("/faq")
	public void faqPage() {
		
	}
	
	/**
	 * File uploads
	 */
	
	/**
	 * Profile information
	 */
	@GetMapping("/profile")
	public void showProfile() {
		
	}
	
	@GetMapping("/documents")
	public void showUploadedDocuments() {
		
	}
	
	/**
	 * Social Media feed
	 */
}
