package com.Itma.model;

import java.io.IOException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Itma.repository.DoctorRepository;
import com.Itma.repository.DoctorSpecializationRepository;


@Service
@Transactional
public class DoctorDao implements IDoctorDao {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	DoctorSpecializationRepository specRepository;

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
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public List<DoctorSpecialization> doctorSpecialization() {
		// TODO Auto-generated method stub
		return specRepository.findAll();
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

	
	

}
