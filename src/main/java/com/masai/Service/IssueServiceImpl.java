package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.IssueStatus;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Exception.OperatorException;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueRepository issueRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Issue addCustomerIssue(Issue issue, int customerId) throws IssueException, CustomerException {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found"));

		issue.setCustomer(customer);
		return issueRepository.save(issue);
	}

	@Override
	public Issue viewlssueByld(Integer issueId) throws IssueException {
		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Not found"));

		return issue;
	}
	
	   @Override
	    public Issue modifyCustomerIssue(Issue issue, Integer issueId, IssueStatus issueStatus) throws OperatorException {

	        if (issue == null) {
	            throw new OperatorException("Issue can't be null");
	        }

	        Optional<Issue> existingIssue = issueRepository.findById(issueId);

	        if (!existingIssue.isPresent())
	            throw new OperatorException("Issue doesn't exist with the given issueId");

	        Issue issueToUpdate = existingIssue.get();

	        issueToUpdate.setIssueType(issue.getIssueType());
	        issueToUpdate.setIssueDescription(issue.getIssueDescription());
	        issueToUpdate.setIssueStatus(issueStatus);

	        Issue updatedIssue = issueRepository.save(issueToUpdate);

	        return updatedIssue;
	    }
		@Override
		public Issue closeCustomerIssue(Integer issueId) throws OperatorException {

			Issue existingIssue = issueRepository.findById(issueId)
					.orElseThrow(() -> new OperatorException("Issue not found with id: " + issueId));
            
			Issue iss;
			if (existingIssue.getIssueStatus() == IssueStatus.PENDING || existingIssue.getIssueStatus() == IssueStatus.OPEN) {
				existingIssue.setIssueStatus(IssueStatus.RESOLVED);
				iss =issueRepository.save(existingIssue);
			} else {
				throw new OperatorException("There are no any issue to be resolved");
			}
			return iss;

		}

}
