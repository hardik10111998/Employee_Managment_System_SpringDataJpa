package com.hardik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hardik.models.Employee;
import com.hardik.models.UserQuery;


public interface UserQueryService {
		
	List<UserQuery> findAllUserQueries(int status);
	
	UserQuery findByQueryId(int queryId);
	
	void GiveQueryReply( UserQuery userQuery);
	
}
