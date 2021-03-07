package com.Itma.model;

import java.io.IOException;
import java.util.List;

public interface IDoctorDao {
public boolean saveDoctor(Doctor doctor) throws IOException;
	
	public List<Doctor> fetchAllDoctors();
	 
	 public Doctor fetchById(String doctor_email);

	//public List<Doctor>  fetchDoctor(String doctor_email);
	
	 public List<DoctorSpecialization> fetchDoctorSpecialization(String doctor_email) ;
	 
	 boolean saveDoctorSpec(DoctorSpecialization doctorSpec) throws IOException;

     //List<Doctor> search(String keyword);
	 
	 public Doctor fetchByIntId(int id);
	 
	 public List<DoctorSchedule> fetchDoctorSchedule(String doctorEmail);
	 
	 public boolean saveSchedule(DoctorSchedule schedule);
}
