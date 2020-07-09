package com.hardik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hardik.models.UserQuery;

@Repository
public interface UserQueryRepository extends JpaRepository<UserQuery, Integer>,JpaSpecificationExecutor<UserQuery> {
	
//	UserQuery findByQueryID(int queryId);

}
