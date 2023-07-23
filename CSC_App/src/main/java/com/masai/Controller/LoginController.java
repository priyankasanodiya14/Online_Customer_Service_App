package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Login;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.LoginRepository;

//@RestController
public class LoginController {
// 
//	
//	@Autowired
//	private LoginRepository loginRepository;
//	
//	@GetMapping("/signIn")
//	public ResponseEntity<Login> getloggedInUserDetailsHandler(Authentication auth){
//		Login login = loginRepository.findByUsername(auth.getName()).orElseThrow(()-> new BadCredentialsException("Credentials not matched"));
//		 return ResponseEntity.ok(login);
//		
//	}
//	
//	
}
