package com.Itma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Itma.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	 // User findById(int id);
	  User findByemail(String email);
	  List<User> findByfirstName(String firstName);
	  List<User> findBylocationStreet(String location);
	  List<User> findBylastName(String lastName);
	  User findByphoneNo(int phoneNo);
	
	
}
