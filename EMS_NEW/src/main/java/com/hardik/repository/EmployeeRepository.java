package com.hardik.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hardik.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 

											,JpaSpecificationExecutor<Employee>	//to generate Dynamic Query In Spring JPA

{
	
	Employee findByUsername(String username);
	
	@Query(value = "SELECT e FROM Employee e WHERE e.username LIKE '%' || :keyword || '%'"
            + " OR e.active LIKE '%' || :keyword || '%'"
            + " OR e.roles LIKE '%' || :keyword || '%'")
    public List<Employee> search(@Param("keyword") String keyword);
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE Employee e "
//			+ "SET e.username= :username,"
//			+ "e.active= :active,"
//			+ "e.roles= :roles,"
//			+ "e.password= :password "
//			+ "WHERE e.id= :id")
//	void updateEmployeeDetail(@Param("username")String username,		
//			@Param("active") Boolean active,
//			@Param("roles")String roles,
//			@Param("password") String password,
//			@Param("id")int id);

}
