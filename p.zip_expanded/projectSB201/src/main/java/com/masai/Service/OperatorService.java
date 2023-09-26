package com.masai.Service;

import java.util.List;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.Operator;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Exception.OperatorException;

public interface OperatorService {
	public Customer findCustomerById(Integer customerId) throws OperatorException;
	public List<Customer> findCustomerByfirstName(String Name) throws OperatorException;
	public Customer findCustomerByUserName(String username) throws OperatorException;
	public Issue closeCustomerIssue(int cid, int issueId) throws CustomerException, IssueException;
	public Customer lockCustomer(int cid) throws CustomerException;
	
	Operator login(String username, String password);
	Operator findByUsername(String username) throws OperatorException;
	public Operator createOperator(Operator operator) throws OperatorException;
}


