package com.maxback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxback.security.JwtTokenUtil;
import com.maxback.security.models.JwtRequest;
import com.maxback.security.models.JwtResponse;
import com.maxback.security.services.JwtUserDetailsService;

@RestController
@RequestMapping(path = "/auth-api/")
public class AuthController {

 	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    /**
     * 
     * @param userDetails
     */
    @RequestMapping(value = "/delete/all")
    public void deleteAllUsers(@AuthenticationPrincipal UserDetails userDetails) {
    	userDetailsService.deleteAllUsers();
    }
    
    /**
     * 
     * @param userDetails
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
    	userDetailsService.deleteUserByUsername(userDetails.getUsername());
    }
    
    /**
     * 
     * @param authenticationRequest
     * @return the newly registered users information 
     * @throws Exception
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDetails registerUser(@RequestBody JwtRequest authenticationRequest) throws Exception {
    	
    	if(this.userDetailsService.existsUsername(authenticationRequest.getUsername())) {
    		return null;
    	}
    	return userDetailsService.createUserByUsername(authenticationRequest.getUsername(), authenticationRequest.getPassword(), authenticationRequest.getRole());
    }
    
    /**
     * 
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
    	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    	final UserDetails userDetails = userDetailsService
    			.loadUserByUsername(authenticationRequest.getUsername());
    	final String token = jwtTokenUtil.generateToken(userDetails);
    	return ResponseEntity.ok(new JwtResponse(token));
    }
    
    /**
     * 
     * @param username
     * @param password
     * @throws Exception
     */
    private void authenticate(String username, String password) throws Exception {
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    	} catch (DisabledException e) {
    		throw new Exception("USER_DISABLED", e);
    	} catch (BadCredentialsException e) {
    		throw new Exception("INVALID_CREDENTIALS", e);
    	}
    }
}
