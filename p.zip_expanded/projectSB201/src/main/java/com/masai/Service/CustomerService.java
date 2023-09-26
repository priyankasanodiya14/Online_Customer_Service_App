package com.masai.Service;

import java.util.List;
import java.util.Optional;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws CustomerException;

	public Issue viewlssueByld(int cid, int issueId) throws IssueException, CustomerException;

	public Issue registerIssue(int cid, Issue issue) throws IssueException, CustomerException;

	public Issue reopenlssue(int customerId, int issueId) throws IssueException, CustomerException;

	public List<Issue> viewAllIssues(int customerId) throws CustomerException, IssueException;

//
	Customer findByUsername(String username) throws CustomerException;
	Customer login(String username, String password) throws CustomerException;
//
	public int forgotPassword(LoginDTO loginDTO, String mobile) throws CustomerException;
//
//	public Customer emailPassword(Integer CustomerID);



	String changePassword(int customerId, String newPassword, String oldPassword) throws CustomerException;

	

}
