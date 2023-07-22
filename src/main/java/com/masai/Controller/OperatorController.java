package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Exception.OperatorException;
import com.masai.Service.OperatorService;

@RestController
public class OperatorController {
   
	@Autowired
	OperatorService operatorService; 

	@GetMapping("/findCustomerById/{customerId}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable Integer customerId) throws OperatorException {
	    Customer foundCustomer = operatorService.findCustomerById(customerId);
	    return new ResponseEntity<Customer>(foundCustomer, HttpStatus.OK);
	}
	
	
	 @GetMapping("/findCustomerByfirstName")
	    public ResponseEntity<List<Customer>> findCustomerByName(@RequestParam String name) throws OperatorException {
	        List<Customer> foundCustomers = operatorService.findCustomerByfirstName(name);
	        return new ResponseEntity<List<Customer>>(foundCustomers, HttpStatus.OK);
	    }
	 @GetMapping("/findByUsername")
	    public ResponseEntity<Customer> findByUsername(@RequestParam String name) throws OperatorException {
	        Customer foundCustomers = operatorService.findCustomerByUserName(name);
	        return new ResponseEntity<Customer>(foundCustomers, HttpStatus.OK);
	    }
}
