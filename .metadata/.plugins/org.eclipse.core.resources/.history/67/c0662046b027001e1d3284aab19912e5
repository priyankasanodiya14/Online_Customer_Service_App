package com.masai.Service;

import java.util.List;

import com.masai.Entity.*;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws CustomerException;
	
	public Issue viewlssueByld(Integer issueId) throws IssueException;
	
	public Issue reopenlssue(Integer customerId,String issueId) throws IssueException, CustomerException;
	
	public List<Issue> viewAllIssues(int customerId) throws CustomerException, IssueException;
	
	public String changePassword(Login l);
	
	public String forgotPassword(Integer CustomerID);
	
	public Customer emailPassword(Integer CustomerID);

}
