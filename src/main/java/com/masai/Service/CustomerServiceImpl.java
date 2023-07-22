package com.masai.Service;

import com.masai.Entity.*;
import com.masai.Exception.IssueException;
import com.masai.Exception.LoginException;
import com.masai.Repository.IssueRepository;

import com.masai.Repository.LoginRepository;
import com.masai.utility.generatorOtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.Repository.CustomerRepository;

import java.util.*;

@Service
public class CustomerServiceImpl implements  CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	IssueRepository ir;

	@Autowired
	LoginRepository lr;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		customer.setUsername(customer.getEmail());
		return customerRepository.save(customer);
	}

	@Override
	public Issue viewlssueByld(int cid, int issueId) throws IssueException, CustomerException {

		Customer c = customerRepository.findById(cid).orElseThrow(()-> new CustomerException("Customer Not Found"));

		List<Issue> lis = c.getIssues();

		for(Issue i: lis){
			if(i.getIssueId() == issueId){
				return i;
			}
		}

		throw new IssueException("Issue Not Found");
	}

	@Override
	public Issue registerIssue(int cid, Issue issue) throws IssueException, CustomerException {
		Customer c = customerRepository.findById(cid).orElseThrow(()-> new CustomerException("Customer Not Found"));
		List<Issue> lis = c.getIssues();
		lis.add(issue);
		c.setIssues(lis);
		issue.setCustomer(c);
		customerRepository.save(c);
		return ir.save(issue);
	}

	@Override
	public Issue reopenlssue(int customerId, int issueId) throws IssueException, CustomerException {
		Customer c = customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found"));
		Issue issue = ir.findById(issueId).orElseThrow(()-> new IssueException("Issue Not Found"));
		if (issue.getIssueStatus().equals(IssueStatus.OPEN)){
			throw new IssueException("Issue is Already Open");
		}
		issue.setIssueStatus(IssueStatus.OPEN);
		return ir.save(issue);
	}

	@Override
	public List<Issue> viewAllIssues(int customerId) throws CustomerException, IssueException {

		Customer c = customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found"));

		List<Issue> lis = c.getIssues();
		if(lis.size() == 0){
			throw new IssueException("No Issue Fonud if you want then raise a issue");
		}

		return lis;
	}

	@Override
	public String changePassword(LoginDTO ld) throws CustomerException, LoginException {


		Customer c = customerRepository.findById(ld.getLoginId()).orElseThrow(()-> new CustomerException("Customer Not Found"));


		if(c.getPassword().equals(ld.getOldPass())){
		       c.setPassword(ld.getNewPass());
		}
		else{
			throw new CustomerException("Password Not Match");
		}
		customerRepository.save(c);
		return "Password Updated!";
	}

	@Override
	public int forgotPassword(LoginDTO loginDTO,String mobile) throws CustomerException {

		Customer c = customerRepository.findById(loginDTO.getLoginId()).orElseThrow(()-> new CustomerException("Customer Not Found"));

		int otp = generatorOtp.generate();
		String cmobile = c.getMobile();
		if(cmobile.equals(mobile)){
			c.setPassword(loginDTO.getNewPass());
			customerRepository.save(c);
			return otp;
		}
		throw new CustomerException("Mobile Not Found");
	}


}
