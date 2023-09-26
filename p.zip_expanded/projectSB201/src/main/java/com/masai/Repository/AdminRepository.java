package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Admin;
import com.masai.Entity.Customer;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Admin findByUsernameAndPassword(String username, String password);
	 Admin findByUsername(String username);
}
