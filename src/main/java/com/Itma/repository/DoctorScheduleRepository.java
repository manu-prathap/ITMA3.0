package com.Itma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Itma.model.DoctorSchedule;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Integer> {

	
	List<DoctorSchedule> findBydoctorDoctorEmail(String doctorEmail);
	DoctorSchedule findBydayOfWeek(String dayOfWeek);
}
