package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Entity.Login;
import com.masai.Repository.LoginRepository;

@Service
public class ManualUserDetailsService implements UserDetailsService {
    
	@Autowired
	 private LoginRepository loginRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Optional<Login> user = loginRepository.findByUsername(username);
		 
		 if(user.isEmpty()) throw new UsernameNotFoundException("User not found");
		 Login us = user.get();
		 
//		when we want to check manually
//		ManualUserDetails manualUserDetails = new ManualUserDetails(us);
//		return manualUserDetails;
		
		 
		List<GrantedAuthority> authorities = new ArrayList<>() ;
		SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+us.getType().toUpperCase()) ;
		authorities.add(autho) ;
		org.springframework.security.core.userdetails.User secUser = new User(us.getUsername(), us.getPassword(),  authorities) ;
		return secUser ;

		
	}

}
