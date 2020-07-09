package com.hardik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hardik.models.Leave;


@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer>,JpaSpecificationExecutor<Leave>{
	
	Leave findByLeaveId(int leaveId);
}
