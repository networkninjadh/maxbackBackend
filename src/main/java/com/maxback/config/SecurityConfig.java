package com.maxback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.maxback.security.JwtRequestFilter;
import com.maxback.security.ApplicationUserPermission;
import com.maxback.security.JwtAuthenticationEntryPoint;

/**
 * 
 * @author Damond Howard
 * @apiNote Entire security policy configuration for the application this secures all routes behind certain user permissions
 */

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	/**
	 * 
	 * @param passwordEncoder @Autowired passwordEncoder from our bean configuration
	 */
	public SecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder);
	}
	
	/**
	 * @param http 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http
			.csrf().disable()
			.authorizeRequests()
			/**
			 * These are a list of the permissions a user needs to have to access each endpoint admin can hit any endpoint admin will be a user on our side
			 * I will make that there can be only one admin 
			 */
			
			/**
			 * Authentication for store api
			 */
			.antMatchers(HttpMethod.DELETE, "/test").hasAuthority(ApplicationUserPermission.STORE_WRITE.getPermission())
			.antMatchers(HttpMethod.GET, "/test").hasAuthority(ApplicationUserPermission.STORE_READ.getPermission())
			.antMatchers(HttpMethod.POST, "/test").hasAuthority(ApplicationUserPermission.STORE_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT, "/test").hasAuthority(ApplicationUserPermission.STORE_WRITE.getPermission())
			.antMatchers(
                    "/configuration/ui",
                    "/configuration/security",
                    "/webjars/**",
                    "/auth-api/signin",
                    "/mappings"
					)
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}