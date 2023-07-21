package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;

import com.masai.Entity.IssueStatus;

import com.masai.Entity.Login;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements  CustomerService{

	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private IssueRepository ir;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		if(customer  == null) throw new CustomerException("Customer is not Valid");
		
		List<Customer> customerlist = cr.findAll();
		
		for(Customer c:customerlist) {
			if(c.getEmail().equals(customer.getEmail())) {
				throw new CustomerException("Customer with given Email Already Exist");
			}
		}
		
		

		return cr.save(customer);
	}

	@Override
	public Issue viewlssueByld(Integer issueId) throws IssueException {
		// TODO Auto-generated method stub

		Issue issue = ir.findById(issueId).orElseThrow(() -> new IssueException("Issue Not Found"));

		return issue;
	}

	@Override
	public Issue reopenlssue(Integer customerId, String issueId) throws IssueException, CustomerException {


		Customer customer = cr.findById(customerId).orElseThrow(() -> new CustomerException("Customer Not Found"));

		List<Issue> issues = customer.getIssues();

		Issue issue = issues.stream().filter(issuee -> issuee.getIssueId().equals(issueId)).findFirst()
				.orElseThrow(() -> new IssueException("Issue Not Found"));

		if (issue.getIssueStatus() == IssueStatus.PENDING)
			throw new IssueException("Issue is Already Opened Please wait for response");

		issue.setIssueStatus(IssueStatus.PENDING);


		return ir.save(issue);
	}

	@Override
	public List<Issue> viewAllIssues(int customerId) throws CustomerException, IssueException {
		// TODO Auto-generated method stub

	
		Customer c = cr.findById(customerId).orElseThrow(()->new CustomerException("Customer Not Found"));
		if(c.getIssues().size() == 0) {

			throw new IssueException("No issue Found");
		}
		return c.getIssues();
	}

	@Override
	public String changePassword(Login l) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String forgotPassword(Integer CustomerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer emailPassword(Integer CustomerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
