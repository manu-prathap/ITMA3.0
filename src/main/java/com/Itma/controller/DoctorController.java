package com.Itma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Itma.model.Doctor;
import com.Itma.model.DoctorDao;
import com.Itma.model.DoctorSpecialization;



@Controller
@RequestMapping("doctor")
public class DoctorController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads/doctor";
		
	@Autowired
	DoctorDao doctorService;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping("/register")
	public String register(Map<String, Object> model) {
        model.put("doctor", new Doctor());
		return "doctor/doctorRegister";
	}
	
	@PostMapping("/save")
	public String submit(Doctor doctor,
			@RequestParam("specialization") final String specialization,
			final @RequestParam("file") MultipartFile file) throws IOException {
		
		DoctorSpecialization spec=new DoctorSpecialization();
		
		doctor.setPassword(encoder.encode(doctor.getPassword()));
		doctorService.saveDoctor(doctor);
		
		
		String fileName = file.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		long size = file.getSize();
		String fileSize = String.valueOf(size);
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());		
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(file.getBytes());
		stream.close();
		
		spec.setSpecialization(specialization);
		spec.setFileName(fileName);
		spec.setFilePath(filePath);
		spec.setFileType(fileType);
		spec.setFileSize(fileSize);
		spec.setCreatedDate(currentTimestamp);
		doctorService.saveDoctorSpec(spec);
		return "user/userHome";
	}
	
	@GetMapping("/login")
	public String login(String email, Map<String, Object> model) {
		
		Doctor doctor = doctorService.fetchById(email);
		
		String name = "Dr "+doctor.getFirstName();
		
		model.put("doctor",doctor);
		model.put("name", name);
		
		return "doctor/home";
		
	}
	
	
}
