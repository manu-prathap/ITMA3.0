package com.Itma.model;

import java.io.IOException;
import java.util.List;


public interface IDoctorDao {
public boolean saveDoctor(Doctor doctor) throws IOException;
	
	public List<Doctor> getAllDoctors();
	
	 public List<DoctorSpecialization> doctorSpecialization() ;
	 
	 public Doctor findById(String doctor_email);

	public List<Doctor>  findDoctor(String doctor_email);

	boolean saveDoctorSpec(DoctorSpecialization doctorSpec) throws IOException;

}
