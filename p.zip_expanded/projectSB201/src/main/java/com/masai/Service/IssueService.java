package com.masai.Service;

import com.masai.Entity.Issue;
import com.masai.Entity.IssueStatus;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Exception.OperatorException;

public interface IssueService {
	 Issue addCustomerIssue(Issue issue, int customerId) throws IssueException, CustomerException;
	 public Issue viewlssueByld(Integer issueId) throws IssueException;
	
	Issue closeCustomerIssue(Integer issueId) throws OperatorException;
	Issue modifyCustomerIssue(Issue issue, Integer issueId, IssueStatus issueStatus, int customerId)
			throws OperatorException, CustomerException;
	
}
