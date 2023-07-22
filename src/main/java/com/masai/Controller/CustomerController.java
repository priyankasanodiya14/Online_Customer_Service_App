package com.masai.Controller;

import com.masai.Entity.LoginDTO;
import com.masai.Exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.IssueStatus;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Exception.OperatorException;
import com.masai.Service.CustomerService;
import com.masai.Service.IssueService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private IssueService issueService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer cust = customerService.registerCustomer(customer);

		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);

	}

	@PostMapping("/addIssues/{customerId}")
	public ResponseEntity<Issue> addIssue(@Valid @RequestBody Issue issue, @PathVariable int customerId)
			throws IssueException, CustomerException {

		Issue iss = issueService.addCustomerIssue(issue, customerId);

		return new ResponseEntity<Issue>(iss, HttpStatus.CREATED);

	}
    @GetMapping("/findIssueById/{issueId}/{cid}")
    public ResponseEntity<Issue> findIssueById(@PathVariable int issueId, @PathVariable int cid)
			throws IssueException, CustomerException {

		Issue issue = customerService.viewlssueByld(cid,issueId);

		return new ResponseEntity<Issue>(issue, HttpStatus.OK);

	}
    @PutMapping("/modifyIssue/{issueId}/{status}")
    public ResponseEntity<Issue> modifyIssue(@Valid @RequestBody Issue issue, @PathVariable Integer issueId, @PathVariable IssueStatus status) throws OperatorException {
        Issue updatedIssue = issueService.modifyCustomerIssue(issue, issueId, status);
        return new ResponseEntity<Issue>(updatedIssue, HttpStatus.OK);
    }
    
    @PutMapping("/closeIssue/{issueId}") // no need to pass request body
    public ResponseEntity<Issue> closeIssue(@PathVariable Integer issueId) throws OperatorException {
        Issue closedIssue = issueService.closeCustomerIssue(issueId);
        return new ResponseEntity<Issue>(closedIssue, HttpStatus.OK);
    }

	@PutMapping("/customer/changePassword") // no need to pass request body
	public ResponseEntity<String> changePassword(@Valid @RequestBody LoginDTO ld) throws OperatorException, CustomerException, LoginException {
		String str = customerService.changePassword(ld);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}


	@PutMapping("/customer/forgetPassword") // no need to pass request body
	public ResponseEntity<Integer> forgetPassword(@Valid @RequestBody LoginDTO ld,@RequestParam String mobile) throws OperatorException, CustomerException, LoginException {
		Integer str = customerService.forgotPassword(ld,mobile);
		return new ResponseEntity<Integer>(str, HttpStatus.OK);
	}
    
}
