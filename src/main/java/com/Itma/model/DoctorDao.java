package com.Itma.model;

import java.io.IOException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Itma.repository.DoctorRepository;
import com.Itma.repository.DoctorScheduleRepository;
import com.Itma.repository.DoctorSpecializationRepository;
import com.Itma.repository.UserDiagnosticsRepository;
import com.Itma.repository.UserDoctorAppointmentRepository;



@Service
//@Transactional
public class DoctorDao implements IDoctorDao {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	DoctorSpecializationRepository specRepository;
	
//	@Autowired
//	DoctorSearchRepository searchRepository;
	
	@Autowired
	DoctorScheduleRepository scheduleRepository;
	
	@Autowired
    UserDoctorAppointmentRepository appointmentRepository;
	
	@Autowired 
	UserDiagnosticsRepository diagnosticRepo;

	@Override
	public boolean saveDoctor(Doctor doctor) throws IOException {
		try {
			if (doctor != null) {
				doctor.setPassword(hashPassword(doctor.getPassword()));
				doctorRepository.save(doctor);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
//	@Override
//	public List<Doctor> search(String keyword){
//		
//		
//		return doctorRepository.search(keyword);
//		
//	}
	
	

	@Override
	public List<Doctor> fetchAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor fetchById(String doctor_email) {
		
		return doctorRepository.findBydoctorEmail(doctor_email);
	}

//	@Override
//	public List<Doctor> findDoctor(String doctor_email) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public boolean saveDoctorSpec(DoctorSpecialization doctorSpec) throws IOException {
		try {
			if (doctorSpec != null) {
				specRepository.save(doctorSpec);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}
	
	@Override
	public List<DoctorSpecialization> fetchDoctorSpecialization(String doctorEmail) {
		// TODO Auto-generated method stub
		//return specRepository.findBydoctorEmail(doctorEmail);
		return null;
	}


	@Override
	public Doctor fetchByIntId(int id) {
		
		Doctor doctor = doctorRepository.findByid(id);
		
		return doctor;
		
	}
	
	
	@Override
	public List<DoctorSchedule> fetchDoctorSchedule(String email){
		
		List<DoctorSchedule> schedules = scheduleRepository.findBydoctorDoctorEmail(email);
		
		return schedules;
	}
	
	@Override
	public boolean saveSchedule(DoctorSchedule schedule) {
		
		try {
		scheduleRepository.save(schedule);
		
		return true;
		
		}catch(IllegalArgumentException e){
			
		return false;
		}
	}
	
	public DoctorSchedule fetchScheduleById(int id) {
		
		DoctorSchedule schedule = scheduleRepository.findByscheduleId(id);
		
		return schedule;
		
	}	
	
	public List<UserDoctorAppointment> fetchAppointment(String email){
		
		List<UserDoctorAppointment> appointments = appointmentRepository.findBydoctorDoctorEmail(email);
		
		
		return appointments;
	}
	
	@Override
	public List<UserDiagnostics> fetchDiagnosticHistory(String email){
		
		List<UserDiagnostics> diagnostics = diagnosticRepo.findBydoctorDoctorEmail(email);
		
		return diagnostics;
	}

}
