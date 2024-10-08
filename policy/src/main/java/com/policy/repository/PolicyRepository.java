package com.policy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.entity.Policy;



@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
//    List<Policy> findByCustomerId(Long customerId);
	
	 Policy findByPolicyId(Long policyId);
	 
	 Optional<Policy> findByCatogery(String catogery);

	//Policy findByPolicyId(long policyId);
}
