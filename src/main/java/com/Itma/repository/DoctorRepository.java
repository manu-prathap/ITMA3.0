package com.Itma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Itma.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
	

	//@Query("SELECT t.address FROM Doctor t WHERE t.doctorEmail = ?1")
	//Doctor findByEmailAddress(String username);
	
	 @Query("SELECT u FROM Doctor u WHERE u.doctorEmail= :username")
	    public Doctor getUserByUsername(@Param("username") String username);

	// @Query(value = "SELECT * FROM doctor WHERE doctorEmail= ?1", nativeQuery = true)
	 // Doctor findByEmailAddress(String emailAddress);
	// 

	//Doctor findByEmail(String email);



	 


}
