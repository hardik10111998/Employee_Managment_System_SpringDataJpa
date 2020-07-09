package com.hardik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardik.models.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByDeptName(String deptName);
}
