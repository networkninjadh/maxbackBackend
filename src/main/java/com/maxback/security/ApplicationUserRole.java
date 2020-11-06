package com.maxback.security;

import static com.maxback.security.ApplicationUserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
/**
 * 
 * @author Damond Howard
 * @apiNote this Enumeration contains user roles
 *
 */
public enum ApplicationUserRole {
	ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, EMPLOYEE_READ, EMPLOYEE_WRITE, CUSTOMER_READ, CUSTOMER_WRITE)),
	EMPLOYEE(Sets.newHashSet(EMPLOYEE_READ, EMPLOYEE_WRITE)),
	CUSTOMER(Sets.newHashSet(CUSTOMER_READ, CUSTOMER_WRITE));

	private final Set<ApplicationUserPermission> permissions;
	
	/**
	 * 
	 * @param permissions a set containing the user permissions based off ApplicationUserPermission enum
	 */
	ApplicationUserRole(Set<ApplicationUserPermission> permissions){
		this.permissions = permissions;
	}
	
	/**
	 * 
	 * @return the set containing the user permissions based off ApplicationUserPermission enum
	 */
	public Set<ApplicationUserPermission> getPermissions(){
		return permissions;
	}
	
	/**
	 * 
	 * @return the user's granted Authorities based off the users permissions
	 */
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> permissions = 
		getPermissions().stream()
			.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
			.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;
	}
}