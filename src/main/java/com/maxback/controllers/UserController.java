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
import com.maxback.models.Profile;
import com.maxback.repositories.ProfileRepository;
import com.maxback.security.services.JwtUserDetailsService;

@RestController
@RequestMapping("/profile-api/")
public class UserController {

	@Autowired
	private JwtUserDetailsService users;
	
	@Autowired
	private ProfileRepository profiles;
	
	@PostMapping("profile/new")
	public Profile createProfile(@RequestBody Profile profile, @AuthenticationPrincipal UserDetails userDetails) {
		Profile myProfile = new Profile();
		myProfile.setUsername(userDetails.getUsername());
		return profiles.save(myProfile);
	}
	
	@GetMapping("/profile/{profile_id}")
	public Profile getProfile(@PathVariable(name = "profile_id") Long profileId, @AuthenticationPrincipal UserDetails userDetails) {
		Optional<Profile> myProfile = profiles.findByUsername(userDetails.getUsername());
		return myProfile.get();
	}
}
