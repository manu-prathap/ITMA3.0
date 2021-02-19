package com.Itma;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Itma.model.Doctor;
import com.Itma.repository.DoctorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stu
		Doctor doctor=	doctorRepository.getUserByUsername(username);
	//Doctor doctor= doctorRepository.findByEmailAddress(username);
	//System.out.print(doctor.getAddress());
	 Set < GrantedAuthority > grantedAuthorities = new HashSet < > ();
     grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
     grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
	 return new org.springframework.security.core.userdetails.User
		 (doctor.getDoctorEmail(),doctor.getPassword(),grantedAuthorities);
	}

}
