package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
}
