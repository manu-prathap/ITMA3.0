package com.Itma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Itma.model.UserDiagnostics;

public interface UserDiagnosticsRepository extends JpaRepository<UserDiagnostics, String> {

	List<UserDiagnostics> findByuserEmail(String email);
	List<UserDiagnostics> findBydoctorDoctorEmail(String email);
	
}
