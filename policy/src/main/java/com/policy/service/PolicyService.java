package com.policy.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.policy.entity.Policy;
import com.policy.repository.*;


@Service
public class PolicyService {

    // Method to purchase a policy (simplified for this example)
//    public Policy purchasePolicy(Long customerId, Policy policy) {
//        policy.setCustomerId(customerId);
//        // In a real application, you would likely save this to a database
//        return policy;
//    }
    
    @Autowired
    private PolicyRepository policyRepository;
    
    public Policy registerPolicy(Policy policy) {
        return policyRepository.save(policy);
    }
    
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
    
    public Policy getPolicyById(Long policyId) {
    	return policyRepository.findByPolicyId(policyId);
    }

    public Optional<Policy> getByCatogery(String catogery) {
    	return policyRepository.findByCatogery(catogery);
    }
}
    

