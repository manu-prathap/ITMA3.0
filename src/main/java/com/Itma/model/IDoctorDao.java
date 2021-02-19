package com.Itma.model;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface IDoctorDao{
public boolean saveDoctor(Doctor doctor) throws IOException;
	
	public List<Doctor> getAllDoctors();
	 
	 public Doctor findById(String doctor_email);

	public List<Doctor>  findDoctor(String doctor_email);
	
	 public List<DoctorSpecialization> doctorSpecialization() ;
	 
	 boolean saveDoctorSpec(DoctorSpecialization doctorSpec) throws IOException;
	 
	 boolean saveDoctorSchedule(DoctorSchedule doctorSchedule) throws IOException;
	 


}
