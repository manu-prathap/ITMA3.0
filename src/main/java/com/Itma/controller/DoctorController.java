package com.Itma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.Itma.model.DoctorSchedule;
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
		spec.setDoctor(doctor);
		doctorService.saveDoctorSpec(spec);
		return "index";
	}
	
	@GetMapping("/login")
	public String login(String email, Map<String, Object> model, HttpSession session) {
		
		email = "donald@email.com";
		
		Doctor doctor = doctorService.fetchById(email);
		
		String name = "Dr "+doctor.getFirstName();
		
		model.put("doctor", doctor);
		model.put("name", name);
		session.setAttribute("doctor", doctor);
		return "doctor/doctorHome";
		
	}
	
	//handler that redirects to schedules viewer
	@GetMapping("/schedules")
	public String viewSchedules(Map<String, Object> model, 
    HttpSession session){
		
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		
		List<DoctorSchedule> scheduleList = doctorService.fetchDoctorSchedule(doctor.getDoctorEmail());
		
		model.put("scheduleList", scheduleList);
		
		return null;
		
	   }
	
	
	@GetMapping("/setschedules")
	public String setSchedules(Map<String, Object> model, HttpSession session) {
		
		String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		List<String> daysOfWeek = Arrays.asList(days);
		
		
		
		model.put("daysOfWeek", daysOfWeek);
		
		model.put("schedule", new DoctorSchedule());
		
		
		return "doctor/doctorSchedule";
		
	}
	
	@PostMapping("/submitschedule")
	public String submitSchedule(Map<String, Object> model, 
			                     HttpSession session, 
			                     DoctorSchedule schedule,
			                     @RequestParam(value = "sTime", required = true)String sTime,
			                     @RequestParam(value = "eTime", required = true)String eTime) {
		
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		
		
		System.out.println(sTime);
		
		Time startTime = Time.valueOf(sTime+":00");
		Time endTime = Time.valueOf(eTime+":00");
		
		schedule.setStartTime(startTime);
		schedule.setEndTime(endTime);
		schedule.setAvailable(true);
		schedule.setDoctor(doctor);
		
        doctorService.saveSchedule(schedule);
		
		
		return "doctor/doctorHome";
	}
	
	
	
}
