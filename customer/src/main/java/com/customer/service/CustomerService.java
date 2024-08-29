package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    @Autowired
//    private PurchasedPolicyRepository purchasedPolicyRepository;

 
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean authenticateCustomer(String email, String password) {
    	return customerRepository.findByEmail(email).map(customer -> customer.getPassword().equals(password)).orElse(false);
//        Customer customer = customerRepository.findByEmail(email);
//        return customer != null && customer.getPassword().equals(password);
    }

//    public List<PurchasedPolicy> getPurchasedPolicies(Long customerId) {
//        return purchasedPolicyRepository.findByCustomerId(customerId);
//    }
//    
   
    
    public Optional<Customer> getByEmail(String email)
    {
     	return customerRepository.findByEmail(email);
    	//return Customer;
    }
}

