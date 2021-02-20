package com.Itma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Itma.model.User;
import com.Itma.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
          
		 User user = userRepository.findByemail(email);
		 
		 if(user == null) {
			 
			 throw new UsernameNotFoundException("User not found!");
		 }

		 
		
		return new UserDetailsImpl(user);
	}

}
