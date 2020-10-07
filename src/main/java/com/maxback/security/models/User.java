package com.maxback.security.models;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.maxback.security.ApplicationUserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7767621136059012494L;
	@Id
	@GeneratedValue
	private Long id;
	@Transient
	private Set<? extends GrantedAuthority> grantedAuthorities;
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String username;
	@Column(name = "role")
	private String role;
	@Column(name = "non_expired")
	private boolean isAccountNonExpired;
	@Column(name = "non_locked")
	private boolean isAccountNonLocked;
	@Column(name = "credentials_non_expired")
	private boolean isCredentialsNonExpired;
	@Column(name = "enabled")
	private boolean isEnabled;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		if (this.role.equals("ROLE_" + ApplicationUserRole.ADMIN.name())) {
			return ApplicationUserRole.ADMIN.getGrantedAuthorities();
		}else if (this.role.equals("ROLE_" + ApplicationUserRole.EMPLOYEE.name())) {
			return ApplicationUserRole.EMPLOYEE.getGrantedAuthorities();
		}else if (this.role.equals("ROLE_" + ApplicationUserRole.CUSTOMER.name())) {
			return ApplicationUserRole.CUSTOMER.getGrantedAuthorities();
		}else {
			return null;
		}
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return  username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}