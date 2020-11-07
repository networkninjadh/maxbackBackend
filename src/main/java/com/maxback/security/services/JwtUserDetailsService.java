package com.maxback.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.maxback.security.ApplicationUserRole;
import com.maxback.security.models.User;
import com.maxback.security.repositories.UserRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository users;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
    public JwtUserDetailsService(UserRepository users) {
        this.users = users;
    }

    public JwtUserDetailsService() {
    	super();
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.users.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }
    
    public UserDetails createUserByUsername(String username, String password, String role) {
    	User newUser = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("password"))
				.role("ROLE_" + role)
				.isAccountNonExpired(true)
				.isAccountNonLocked(true)
				.isCredentialsNonExpired(true)
				.isEnabled(true)
				.build();
    		this.users.save(newUser);
    		return newUser;
    }
    
    public boolean existsUsername(String username) {
		if (this.users.existsUserByUsername(username)) {
			return true;
		}
		return false;
	}
}