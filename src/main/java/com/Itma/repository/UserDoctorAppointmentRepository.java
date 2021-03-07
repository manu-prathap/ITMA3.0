package com.Itma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Itma.model.UserDoctorAppointment;

public interface UserDoctorAppointmentRepository extends JpaRepository<UserDoctorAppointment, String> {

	 List<UserDoctorAppointment> findByuserEmail(String email);
	 
	 List<UserDoctorAppointment> findBydoctorDoctorEmail(String email);
	
	 List<UserDoctorAppointment> findByscheduleScheduleId(int id);
	
}
