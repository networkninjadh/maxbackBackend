package com.maxback.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping(path = "/test")
	public String getTest(@AuthenticationPrincipal UserDetails userDetails) {
		return "Test passed spring security works";
	}
}
