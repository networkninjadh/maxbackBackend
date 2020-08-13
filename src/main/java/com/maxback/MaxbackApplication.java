package com.maxback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maxback.models.User;
import com.maxback.repositories.UserRepository;

@SpringBootApplication
public class MaxbackApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(MaxbackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User me = new User();
		me.setUsername("networkninjadh");
		me.setPassword(passwordEncoder.encode("papayaland"));
		userRepository.save(me);
		
	}

}
