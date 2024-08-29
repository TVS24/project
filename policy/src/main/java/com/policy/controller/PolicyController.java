package com.policy.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.policy.entity.Policy;
import com.policy.exception.PolicyNotFoundException;
import com.policy.repository.PolicyRepository;
import com.policy.service.PolicyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class PolicyController {

	public static Logger logger=LoggerFactory.getLogger(PolicyController.class);
    //@Autowired
//    private CustomerService customerService;

    @Autowired
    private PolicyService policyService;
    
     @PostMapping("/savepolicy")
     public Policy registerPolicy(@RequestBody Policy policy) {
    	 return policyService.registerPolicy(policy);
     }
     
     
     @GetMapping("/policies")
     public List<Policy> getAllPolicies() {
         return policyService.getAllPolicies();
     }
     
     @GetMapping("policy/{catogery}")
     public Policy getPolicyByCategory(@PathVariable String catogery) throws PolicyNotFoundException
     {
    	 return policyService.getByCatogery(catogery).orElseThrow(()->new PolicyNotFoundException("policy not found"));
     } 
     
     @GetMapping("id/{policyId}")
     public Policy getPolicyById(@PathVariable Long policyId) {
    	 return policyService.getPolicyById(policyId);
     }
     
     
     
//     @GetMapping("/policies")
//     public ResponseEntity<List<Policy>> getAllPolicies() {
//         return (ResponseEntity<List<Policy>>) policyService.getAllPolicies();
//     }
     
//    @Autowired
//    private PurchasedPolicyService purchasedPolicyService;

    // View all purchased policies for a customer
//    @GetMapping
//    public List<PurchasedPolicy> getPurchasedPolicies(@PathVariable Long customerId) {
//        Customer customer = customerService.getCustomerById(customerId);
//        if (customer == null) {
//            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
//        }
//        return purchasedPolicyService.getPurchasedPoliciesByCustomerId(customerId);
//    }

    // Purchase a new policy
//    @PostMapping
//    public PurchasedPolicy purchasePolicy(@PathVariable Long customerId, @RequestBody Policy policy) {
//        Customer customer = customerService.getCustomerById(customerId);
//        if (customer == null) {
//            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
//        }

//        Policy existingPolicy = policyService.getPolicyById(policy.getId());
//        if (existingPolicy == null) {
//            throw new PolicyNotFoundException("Policy with id " + policy.getId() + " not found");
//        }

        // Purchase the policy
//        PurchasedPolicy purchasedPolicy = purchasedPolicyService.purchasePolicy(customerId, policy);
//        return purchasedPolicy;
  }
        
