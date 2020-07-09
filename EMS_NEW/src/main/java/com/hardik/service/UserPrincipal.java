package com.hardik.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hardik.models.Employee;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails {
	
	private Employee employee;
	

	public UserPrincipal(Employee user) {
		super();
		this.employee = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<>();

//	        // Extract list of permissions (name)
//	        this.user.getPermissionList().forEach(p -> {
//	            GrantedAuthority authority = new SimpleGrantedAuthority(p);
//	            authorities.add(authority);
//	        });

	        // Extract list of roles (ROLE_name)
	        this.employee.getRoleList().forEach(r -> {
	            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
	            authorities.add(authority);
	        });

	        return authorities;
	}

	@Override
	public String getPassword() {
		
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		
		return employee.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return  this.employee.getActive() == true;
	}

}
