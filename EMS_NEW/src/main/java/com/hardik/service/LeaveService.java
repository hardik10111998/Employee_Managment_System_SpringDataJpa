package com.hardik.service;

import java.util.List;

import com.hardik.models.Leave;



public interface LeaveService {
	
	List<Leave> findAllLeaves(int status);
	
	Leave findByLeaveId(int leaveId);
	
	void grantLeave(int leaveId);
	
	void rejectLeave(int leaveId);
}
