package com.hardik.service;

import java.util.Date;
import java.util.List;

//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.hardik.models.Employee;
import com.hardik.models.Leave;
import com.hardik.models.UserQuery;

public interface EmployeeService {
	
	void Save(Employee employee);
	
	void deleteEmployee(int empId);
	
	void updateEmployeeDetails(Employee employee);
	
	Employee findByUsername(String empName);
	
	Employee findById(int empId);
	
	List<Employee> search(String keyword);

	List<Employee> sortByProperty(String property);

	List<Employee> findAll(Pageable pageable);
	
	List<Employee> findAll();
		
	List<Employee> getEmployeeBetweenDates(Date fromDate, Date toDate, String name, Pageable pageable);
	
	void attendance(String userName,String inTime,String outTime);
	
	void sendAmount(int empId,double salary);
	
	void addLeave(String userName,Leave leave);
	
	void addRaisedQuery(String userName,UserQuery userQuery);

}
