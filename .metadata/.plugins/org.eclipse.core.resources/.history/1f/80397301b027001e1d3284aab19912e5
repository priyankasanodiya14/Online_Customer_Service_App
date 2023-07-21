package com.masai.Service;


import java.util.List;

import com.masai.Entity.CurrentOperatorSession;
import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.Login;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;

public interface operatorService {
	

	public CurrentOperatorSession loginOperator(Login login) throws OperatorException, LoginException;
	
	public Issue addCustomerIssue(Issue issue) throws OperatorException;
	
	public String sendIntimidationEmailToCustomer(Integer issueId, Integer customerId) throws OperatorException;

	public Issue modifyCustomerIssue(Issue issue, Integer issueId) throws OperatorException;
	
	public String sendModificationEmailToCustomer(Integer issueId, Integer customerId) throws OperatorException;
	
	public void closeCustomerIssue(Issue issue, Integer issueId) throws OperatorException;
	
	public Customer findCustomerById(Integer customerId) throws OperatorException;
	
	public List<Customer> findCustomerByName(String fName) throws OperatorException;
	
	public Customer findCustomerByEmail(String email) throws OperatorException;
	
	public boolean lockCustomer(Integer customerId) throws OperatorException;

	

}
