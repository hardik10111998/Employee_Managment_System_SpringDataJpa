package com.hardik.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hardik.models.Leave;
import com.hardik.repository.LeaveRepository;


@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaveRepo;
	
//	@Autowired
//	private CustomSpecification custSpec;
	
	@Override
	public List<Leave> findAllLeaves(int status) {
		return leaveRepo.findAll(findAllLeavesByStatus(status));
	}
	@Override
	public Leave findByLeaveId(int leaveId) {
		return leaveRepo.findByLeaveId(leaveId);
	}
	@Override
	public void grantLeave(int leaveId) {
		Leave leave= leaveRepo.findByLeaveId(leaveId);
		leave.setStatus(1);
		leaveRepo.save(leave);
	}
	public void rejectLeave(int leaveId){
		
		Leave leave= leaveRepo.findByLeaveId(leaveId);
		leave.setStatus(2);
		leaveRepo.save(leave);	
	}

	//-----------------------------------------------------------------------------
	public  Specification<Leave> findAllLeavesByStatus(int status)
	{
		return new Specification<Leave>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Leave> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return cb.equal(root.get("status"), status);
			}

		};
	}
	//-----------------------------------------------------------------------------
	
}
