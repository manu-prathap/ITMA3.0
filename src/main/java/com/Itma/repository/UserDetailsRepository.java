package com.Itma.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Itma.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
	
	
	//UserDetails findByuserEmail(String email);
	List<UserDetails> findBybloodGroup(String bloodGroup);

}
