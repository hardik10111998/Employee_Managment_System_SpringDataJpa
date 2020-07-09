package com.hardik.service;

import java.util.List;

//import javax.xml.ws.WebServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.models.Department;
import com.hardik.repository.DepartmentRepository;

@Service
@Transactional
public class DeapartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	public void save(Department department)
	{
		deptRepo.save(department);
	}

	@Override
	public List<Department> findAllDepartments() {
		return deptRepo.findAll();
	}

	@Override
	public Department findByDeptName(String deptName) {
		
		return deptRepo.findByDeptName(deptName);
	}
}
