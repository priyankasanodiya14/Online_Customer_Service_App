package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.IssueStatus;
import com.masai.Entity.Operator;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Exception.OperatorException;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;
import com.masai.Repository.OperatorRepository;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	IssueRepository ir;

	@Autowired
	OperatorRepository operatorRepository;
	
	@Override
	public Operator findByUsername(String username) throws OperatorException {
		Operator opt= operatorRepository.findByUsername(username);
		 if(opt == null) throw new OperatorException("No user found");
		 return opt;
	}

	@Override
	public Operator login(String username, String password) {
		return operatorRepository.findByUsernameAndPassword(username, password);

	}

	@Override
	public Customer findCustomerById(Integer customerId) throws OperatorException {

		if (customerId == null) {
			throw new OperatorException("CustomerId can't be null");
		}

		Optional<Customer> existingCustomer = customerRepository.findById(customerId);

		if (existingCustomer.isEmpty())
			throw new OperatorException("No customer exists with given customerId");

		return existingCustomer.get();
	}

	@Override
	public List<Customer> findCustomerByfirstName(String name) throws OperatorException {

		if (name == null || name.isEmpty()) {
			throw new OperatorException("Name cannot be empty");
		}

		List<Customer> customers = customerRepository.findCustomerByfirstName(name);

		return customers;
	}

	@Override
	public Customer findCustomerByUserName(String name) throws OperatorException {

		if (name == null) {
			throw new OperatorException("CustomerId can't be null");
		}

		Customer existingCustomer = customerRepository.findByUsername(name);
		if (existingCustomer == null)
			throw new OperatorException("No customer exists with given email");

		return existingCustomer;
	}

	@Override
	public Issue closeCustomerIssue(int cid, int issueId) throws CustomerException, IssueException {

		Customer customer = customerRepository.findById(cid)
				.orElseThrow(() -> new CustomerException("Customer Not Found"));

		List<Issue> li = customer.getIssues();

		Issue issue = li.stream().filter(issu -> issu.getIssueId() == issueId).findFirst()
				.orElseThrow(() -> new IssueException("Issue not found"));

		issue.setIssueStatus(IssueStatus.RESOLVED);

		ir.save(issue);

		return issue;
	}

	@Override
	public Customer lockCustomer(int cid) throws CustomerException {
		Customer c = customerRepository.findById(cid).orElseThrow(() -> new CustomerException("Customer Not Found"));
		c.setActive(false);
		customerRepository.save(c);
		return c;
	}

	@Override
	public Operator createOperator(Operator operator) throws OperatorException {
		operator.setUsername(operator.getEmail());
		return operatorRepository.save(operator);
	
	}

}
