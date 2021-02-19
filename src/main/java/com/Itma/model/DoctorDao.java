package com.Itma.model;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Itma.repository.DoctorRepository;
import com.Itma.repository.DoctorScheduleRepository;
import com.Itma.repository.DoctorSpecializationRepository;




@Service
@Transactional
public class DoctorDao implements IDoctorDao {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	DoctorSpecializationRepository specRepository;
	
	@Autowired
	DoctorScheduleRepository scheduleRepository;

	@Override
	public boolean saveDoctor(Doctor doctor) throws IOException {
		try {
			if (doctor != null) {
				//doctor.setPassword(hashPassword(doctor.getPassword()));
				doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
				doctorRepository.save(doctor);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	//private String hashPassword(String plainTextPassword){
		//return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	//}
	

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor findById(String doctor_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> findDoctor(String doctor_email) {
		// TODO Auto-generated method stub
		return null;
	}
	
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
	public List<DoctorSpecialization> doctorSpecialization() {
		// TODO Auto-generated method stub
		return specRepository.findAll();
	}

	public boolean saveDoctorSchedule(DoctorSchedule doctorSchedule) {
		try {
			if (doctorSchedule != null) {
				scheduleRepository.save(doctorSchedule);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
	}

	}



