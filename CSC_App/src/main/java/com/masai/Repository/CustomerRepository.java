package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	 Customer findByUsername(String email);
	 Customer findByMobile(String mobile);
	List<Customer> findCustomerByfirstName(String name);
}
