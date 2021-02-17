package com.Itma.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Itma.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	  Admin findById(int id);
	  List<Admin> findByfirstName(String firstName);
	  List<Admin> findBylastName(String lastName);
	 
	
}

