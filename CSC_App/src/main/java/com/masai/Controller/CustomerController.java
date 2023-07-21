package com.masai.Controller;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Exception.CustomerException;
import com.masai.Exception.IssueException;
import com.masai.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
        return new ResponseEntity<>(customerService.registerCustomer(customer), HttpStatus.CREATED);
    }

    @PatchMapping("/ReOpenIssue/{cid}/{iid}")
    public ResponseEntity<Issue> reOpenIssue(@PathVariable("cid") Integer cid, @PathVariable("iid") String iid) throws CustomerException, IssueException {
        return new ResponseEntity<>(customerService.reopenlssue(cid,iid), HttpStatus.CREATED);
    }

    @GetMapping("/getIssueById/{iid}")
    public ResponseEntity<Issue> getIssueById(@PathVariable("iid") Integer iid) throws CustomerException, IssueException {
        return new ResponseEntity<>(customerService.viewlssueByld(iid), HttpStatus.CREATED);
    }

    @GetMapping("/getIssueAllId/{iid}")
    public ResponseEntity<List<Issue>> getAllIssue(@PathVariable("cid") Integer cid) throws CustomerException, IssueException {
        return new ResponseEntity<>(customerService.viewAllIssues(cid), HttpStatus.CREATED);
    }

}
