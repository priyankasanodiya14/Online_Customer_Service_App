package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Entity.IssueStatus;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;
import com.masai.Repository.LoginRepository;
import com.masai.Utility.generatorOtp;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements  CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	IssueRepository ir;

	@Autowired
	LoginRepository lr;
	
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		customer.setUsername(customer.getEmail());
		return customerRepository.save(customer);
	}
	@Override
	public Customer login(String username, String password) throws CustomerException {
		
	    Customer customer = customerRepository.findByUsernameAndPassword(username, password);

	    if (customer != null) {
	        return customer;
	    } else {
	        return null;
	    }
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
		Customer customer = customerRepository.findById(cid)
				.orElseThrow(() -> new CustomerException("Customer not found"));

		issue.setCustomer(customer);
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
	public String changePassword(int customerId, String newPassword, String oldPassword) throws CustomerException {


	    Customer c = customerRepository.findById(customerId).get();
	     if(c==null) throw new CustomerException("customer not found");
	     if(c.getPassword()==oldPassword) {
	    	 c.setPassword(newPassword);
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
	@Override
	public Customer findByUsername(String username) throws CustomerException {
		Customer opt= customerRepository.findByUsername(username);
		 if(opt == null) throw new CustomerException("No user found");
		 return opt;
	}
	


}
