package com.masai.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.CurrentOperatorSession;
import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.IssueStatus;
import com.masai.Entity.Login;
import com.masai.Entity.Operator;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;
import com.masai.Repository.CurrentOperatorSessionRepository;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;
import com.masai.Repository.OperatorRepository;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;

@Service
@Slf4j
public class OperatorServiceImpl implements operatorService {

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	private CurrentOperatorSessionRepository currentOperatorSessionRepository;

	@Override
	public CurrentOperatorSession loginOperator(Login login) throws OperatorException, LoginException {

		Operator existingOperator = operatorRepository.findByUsername(login.getUsername());

		if (existingOperator == null) {
			throw new LoginException("Please Enter a valid username number");
		}

		Optional<CurrentOperatorSession> validOperatorSessionOpt = currentOperatorSessionRepository
				.findById(existingOperator.getOperatorId());

		if (validOperatorSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this username");
		}

		if (existingOperator.getLogin().getPassword().equals(login.getPassword())) {

			String key = RandomString.make(6);

			CurrentOperatorSession currentOperatorSession = new CurrentOperatorSession(existingOperator.getOperatorId(),
					key, LocalDateTime.now());

			currentOperatorSessionRepository.save(currentOperatorSession);

			return currentOperatorSession;
		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public Issue addCustomerIssue(Issue issue) throws OperatorException {

		if (issue == null) {
			throw new OperatorException("Issue can't be null");
		}

		return issueRepository.save(issue);

	}

	@Override
	public Issue modifyCustomerIssue(Issue issue, Integer issueId) throws OperatorException {

		if (issue == null) {
			throw new OperatorException("Issue can't be null");
		}

		Optional<Issue> existingIssue = issueRepository.findById(issueId);

		if (!existingIssue.isPresent())
			throw new OperatorException("Issue doesn't exist with given issueId");

		Issue issueToUpdate = existingIssue.get();

		issueToUpdate.setIssueType(issue.getIssueType());

		issueToUpdate.setIssueDescription(issue.getIssueDescription());
		issueToUpdate.setIssueStatus(issue.getIssueStatus());

		Issue updatedIssue = issueRepository.save(issueToUpdate);

		return updatedIssue;
	}

	@Override
	public void closeCustomerIssue(Issue issue, Integer issueId) throws OperatorException {

		Issue existingIssue = issueRepository.findById(issueId)
				.orElseThrow(() -> new OperatorException("Issue not found with id: " + issueId));

		if (existingIssue.getIssueStatus() == IssueStatus.PENDING) {
			existingIssue.setIssueStatus(IssueStatus.RESOLVED);
			issueRepository.save(existingIssue);
		} else {
			throw new OperatorException("Issue is not in PENDING status");
		}

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
	public List<Customer> findCustomerByName(String name) throws OperatorException {

		if (name == null || name.isEmpty()) {
			throw new OperatorException("Name cannot be empty");
		}

		List<Customer> customers = customerRepository.findByName(name);

		return customers;
	}

	@Override
	public Customer findCustomerByEmail(String email) throws OperatorException {

		if (email == null) {
			throw new OperatorException("CustomerId can't be null");
		}

		Optional<Customer> existingCustomer = customerRepository.findByEmail(email);

		if (existingCustomer.isEmpty())
			throw new OperatorException("No customer exists with given email");

		return existingCustomer.get();
	}

	@Override
	public String sendIntimidationEmailToCustomer(Integer issueId, Integer customerId) throws OperatorException {
		return null;
	}

	@Override
	public String sendModificationEmailToCustomer(Integer issueId, Integer customerId) throws OperatorException {

		return null;
	}

	@Override
	public boolean lockCustomer(Integer customerId) throws OperatorException {
		return false;
	}

	
	


}
