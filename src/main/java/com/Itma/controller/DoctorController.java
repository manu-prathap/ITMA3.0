package com.Itma.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Itma.model.Doctor;
import com.Itma.model.DoctorDao;
import com.Itma.model.DoctorSpecialization;
import com.Itma.model.User;
import com.Itma.model.UserDao;


@Controller
@RequestMapping("doctor")
public class DoctorController {
	
	//private static Logger log = LoggerFactory.getLogger(DoctorController.class);
	//public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	
	@Autowired
	DoctorDao doctorService;
	
	@GetMapping("/docreg")
	public String showSignupPage() {
		return "doctor/doctorRegister";
	}
	@PostMapping("/save")
	public String save(Doctor doctor) throws IOException {
		
		//doctorService.saveDoctor(doctor);
		return "user/userHome";
	}
	
	@GetMapping("/do")
	public String showSignupPage1() {
		return "doctor/hello";
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.POST)
	//@PostMapping("/hi")
	public String save() throws IOException {
		return "user/userHome";
	}
	
	
}
