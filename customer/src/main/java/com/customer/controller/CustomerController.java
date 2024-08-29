package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.exception.CustomerNotFoundException;
import com.customer.model.Policy;
import com.customer.model.Response;
import com.customer.service.CustomerService;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private PolicyService policyService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }
                    
    @PostMapping("/login")
    public boolean loginCustomer(@RequestParam String email, @RequestParam String password) {
        return customerService.authenticateCustomer(email, password);
    }
    
//    @GetMapping("/{email}/policy")
//    public Customer getByEmail(@PathVariable String email) throws CustomerNotFoundException {
//        return customerService.getByEmail(email).orElseThrow(()->new CustomerNotFoundException("unknowm user"));
//    }
//    
    
    @GetMapping("/allpolicies")
    public ResponseEntity<Response> getAllPolicies(){
    	Response response = new Response();
    	List<Policy> listOfPolicies = restTemplate.getForObject("http://localhost:8082/api/policies", List.class);
    	response.setPolicies(listOfPolicies);
    	return new ResponseEntity<Response>(response,HttpStatus.OK);
    	//return (ResponseEntity<List<Policy>>) policyService.getAllPolicies();
    }
//    @GetMapping("/policies")
//    public ResponseEntity<Policy> getAllPolicies() {
//    	
//    	List<policy>listOfPolicies = restTemplate.getForObject("http://localhost:8082/api/policies", List.class);
//        return new List<policy>();
//    }
    

//    @GetMapping("/{id}/policies")
//    public List<PurchasedPolicy> getPurchasedPolicies(@PathVariable Long id) {
//        return customerService.getPurchasedPolicies(id);
//    }
//
//    @PostMapping("/{id}/purchase")
//    public PurchasedPolicy purchasePolicy(@PathVariable Long id, @RequestBody PurchasedPolicy policy) {
//        return policyService.purchasePolicy(id, policy);
//    }
}

