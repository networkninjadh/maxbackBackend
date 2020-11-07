package com.maxback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maxback.security.ApplicationUserRole;
import com.maxback.security.models.User;
import com.maxback.security.repositories.UserRepository;


@SpringBootApplication
public class MaxbackApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository users;
	
	public static void main(String[] args) {
		SpringApplication.run(MaxbackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		
//		User userTwoUser = User.builder()
//				.username("admin")
//				.password(passwordEncoder.encode("password"))
//				.role("ROLE_" + ApplicationUserRole.ADMIN.name())
//				.isAccountNonExpired(true)
//				.isAccountNonLocked(true)
//				.isCredentialsNonExpired(true)
//				.isEnabled(true)
//				.build();
//		this.users.save(userTwoUser);
	}

}
