package com.maxback.security;

/**
 * 
 * @author Damond Howard
 * @apiNote Enumeration containing certain application user permissions has sets
 *
 */
public enum ApplicationUserPermission {
	STORE_READ("store:read"),
	STORE_WRITE("store:write");

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