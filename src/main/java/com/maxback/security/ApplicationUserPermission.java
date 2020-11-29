package com.maxback.security;

/**
 * 
 * @author Damond Howard
 * @apiNote Enumeration containing certain application user permissions has sets
 *
 */
public enum ApplicationUserPermission {
	CUSTOMER_READ("customer:read"),
	CUSTOMER_WRITE("customer:write"),
	EMPLOYEE_READ("employee:read"),
	EMPLOYEE_WRITE("employee:write"),
	ADMIN_READ("admin:read"),
	ADMIN_WRITE("admin:write");

	private final String permission;
	
	/**
	 * 
	 * @param creates a set that represents a permission
	 */
	ApplicationUserPermission(String permission){
		this.permission = permission;
	}
	
	/**
	 * 
	 * @return the permission 
	 */
	public String getPermission() {
		return permission;
	}
}