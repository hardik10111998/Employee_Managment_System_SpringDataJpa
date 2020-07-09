package com.hardik.service;

import java.util.List;

import com.hardik.models.Department;



public interface DepartmentService {
	
	void save(Department department);
	
	List<Department> findAllDepartments();
	
	Department findByDeptName(String deptName);
}
