package com.hardik.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hardik.models.UserQuery;
import com.hardik.repository.UserQueryRepository;

@Service
@Transactional
public class UserQueryServiceImpl implements UserQueryService {
	
	@Autowired
	public UserQueryRepository queryRepository;

	@Override
	public List<UserQuery> findAllUserQueries(int status) {
		
		return queryRepository.findAll(findAllUserQueriesByStatus(status));
	}

	//-----------------------------------------------------------------------------
		public  Specification<UserQuery> findAllUserQueriesByStatus(int status)
		{
			return new Specification<UserQuery>() {

				private static final long serialVersionUID = 1L;

				@Override
				public Predicate toPredicate(Root<UserQuery> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					// TODO Auto-generated method stub
					return cb.equal(root.get("status"), status);
				}

			};
		}
		//-----------------------------------------------------------------------------

		@Override
		public UserQuery findByQueryId(int queryId) {
			
			return queryRepository.findById(queryId).get();
		}

		@Override
		public void GiveQueryReply(UserQuery userQuery) {
			
			UserQuery oldQuery=queryRepository.findById(userQuery.getQueryId()).get();
			oldQuery.setStatus(true);			//only modify status and reply given
			oldQuery.setReply(userQuery.getReply());
			queryRepository.save(oldQuery);
			
		}
		

}
