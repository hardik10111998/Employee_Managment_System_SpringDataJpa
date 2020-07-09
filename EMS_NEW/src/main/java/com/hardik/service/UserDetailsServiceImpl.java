package com.hardik.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hardik.models.Employee;
import com.hardik.repository.EmployeeRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String empName) throws UsernameNotFoundException {
		Employee user= employeeRepository.findByUsername(empName);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
				
				
		return new UserPrincipal(user);
	}

}
