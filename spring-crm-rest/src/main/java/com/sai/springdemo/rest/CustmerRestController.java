package com.sai.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.springdemo.entity.Customer;
import com.sai.springdemo.service.CustomerService;

@RestController
@RequestMapping("/custapi")
public class CustmerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theContact = customerService.getCustomer(customerId);
		
		if (theContact == null) {
			throw new ContactNotFoundException("Contact id not found - " + customerId);
		}
		
		return theContact;
	}
		
	
}


















