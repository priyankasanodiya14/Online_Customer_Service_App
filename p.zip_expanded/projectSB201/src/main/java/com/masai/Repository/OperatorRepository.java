package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {

	Operator findByUsernameAndPassword(String username, String password);
	Operator findByUsername(String username);
	
}
