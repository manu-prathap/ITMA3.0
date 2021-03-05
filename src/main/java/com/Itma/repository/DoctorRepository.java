package com.Itma.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Itma.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


	
	public Doctor findBydoctorEmail(String email);
	public Doctor findByid(int id);
	public List<Doctor> findByfirstName(String firstName);
	public List<Doctor> findBylastName(String lastName);
	
//	@Query(value = "SELECT * FROM doctor WHERE MATCH(country, state, district, address, doctor_email, first-name, last_name) AGAINST(?1) ")
//	public List<Doctor> search(String keyword);
	
	
}
