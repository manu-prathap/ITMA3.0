package com.Itma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Itma.model.Doctor;
import com.Itma.model.DoctorDao;
import com.Itma.model.DoctorSchedule;
import com.Itma.model.DoctorSpecialization;



@Controller
//@RequestMapping("doctor")
public class DoctorController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
		
	@Autowired
	DoctorDao doctorService;
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");
	        return "doctor/login";
	    }

	    @RequestMapping(value = {"/","/doctorHome"}, method = RequestMethod.GET)
	    public String welcome(Model model) {
	        return "doctor/doctorHome";
	    }
	
		
	@GetMapping("/register")
	public String register(Map<String, Object> model) {
        model.put("doctor", new Doctor());
		return "doctor/doctorRegister";
	}
	
	@PostMapping("/save")
	public String submit(Doctor doctor,
			@RequestParam("specialization") final String specialization,
			final @RequestParam("file") MultipartFile file ,@ModelAttribute("doctorEmail")String  doctorEmail,
            Model model) throws IOException {
		DoctorSpecialization spec=new DoctorSpecialization();
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
		String email=doctor.getDoctorEmail();
		spec.setDoctorEmail(email);
		spec.setSpecialization(specialization);
		spec.setFileName(fileName);
		spec.setFilePath(filePath);
		spec.setFileType(fileType);
		spec.setFileSize(fileSize);
		spec.setCreatedDate(currentTimestamp);
		doctorService.saveDoctorSpec(spec);
		//return "user/userHome";
		model.addAttribute("doctorEmail",doctorEmail);
		return "doctor/login";
		//return "doctor/doctorSchedule";
	}
	
	@GetMapping("/schedule")
	public String schedule() {
		return "doctor/doctorSchedule";
	}
	
	@PostMapping("/saveSchedule1")
	public @ResponseBody ResponseEntity<?> submitschedule1(DoctorSchedule doctorSchedule,Doctor doctor)
	{
		//doctorSchedule.setDoctor(doctor);
		doctorService.saveDoctorSchedule(doctorSchedule);
		//return "doctor/welcome";
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@PostMapping("/saveSchedule")
	public String submitschedule(DoctorSchedule doctorSchedule) throws IOException {
		//doctorSchedule.setDoctorEmail(doctorEmail);
		//doctorSchedule.setDoctor(doctor);
		doctorService.saveDoctorSchedule(doctorSchedule);
		return "doctor/welcome";
	}

}
