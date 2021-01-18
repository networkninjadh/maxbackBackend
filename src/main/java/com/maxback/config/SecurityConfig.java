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
			 * Admin API
			 */
			.antMatchers(HttpMethod.DELETE, "/admin-api/**").hasAuthority(ApplicationUserPermission.ADMIN_WRITE.getPermission())
			.antMatchers(HttpMethod.GET, "/admin-api/**").hasAuthority(ApplicationUserPermission.ADMIN_READ.getPermission())
			.antMatchers(HttpMethod.POST, "/admin-api/**").hasAuthority(ApplicationUserPermission.ADMIN_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT, "/admin-api/**").hasAuthority(ApplicationUserPermission.ADMIN_WRITE.getPermission())
			/**
			 * Customer API
			 */
			.antMatchers(HttpMethod.DELETE, "/profile-api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.GET, "/profile-api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_READ.getPermission())
			.antMatchers(HttpMethod.POST, "/profile-api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT, "/profile-api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			/**
			 * Employee API
			 */
			.antMatchers(HttpMethod.DELETE, "/employee-api/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
			.antMatchers(HttpMethod.GET, "/employee-api/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_READ.getPermission())
			.antMatchers(HttpMethod.POST, "/employee-api/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT, "/employee-api/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
			/**
			 * Aws File Controller authentication
			 */
			.antMatchers(HttpMethod.POST,"/files/customer-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT,"/files/customer-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.GET,"/files/customer-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_READ.getPermission())
			.antMatchers(HttpMethod.DELETE,"/files/customer-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			
			.antMatchers(HttpMethod.POST,"/files/employee-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT,"/files/employee-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.GET,"/files/employee-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_READ.getPermission())
			.antMatchers(HttpMethod.DELETE,"/files/employee-profile/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			
			/**
			 * Message Controller
			 */
			.antMatchers(HttpMethod.POST,"/message-api/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT,"/message-api/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			.antMatchers(HttpMethod.GET,"/message-api/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_READ.getPermission())
			.antMatchers(HttpMethod.DELETE,"/message-api/**" ).hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
			
			.antMatchers(
					"/swagger-resources/**",
					"/v2/api-docs",
					"/swagger-ui.html",
                    "/configuration/ui",
                    "/configuration/security",
                    "/webjars/**",
                    "/auth-api/signin",
                    "/auth-api/register",
                    "/mappings",
                    "/dist/**",
                    "/public/**",
                    "/index.html",
                    "/main-es2015.js",
                    "/main-es5.js",
                    "/polyfills-es2015.js",
                    "/favicon.ico",
                    "/**",
                    "runtime-es2015.js",
                    "/"
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