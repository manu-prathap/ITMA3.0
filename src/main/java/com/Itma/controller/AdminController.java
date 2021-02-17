package com.Itma.controller;


import java.io.IOException;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Itma.model.AdminDao;
import com.Itma.model.Admin;


@Controller
@RequestMapping("admin")
public class AdminController {


	@Autowired
	AdminDao adminDao;
	
	
	
	@GetMapping("/register")
	public String register(Map<String, Object> model) {
		System.out.println("welcome");
        model.put("adminForm", new Admin());
		return "admin/adminRegister";

	}
	@PostMapping("/submit")
	public String submit(@RequestParam("id") MultipartFile multipartFile, Admin adminForm) throws IOException {
		
		Admin admin = new Admin();
		admin.setEmail(adminForm.getAdminEmail());
		admin.setPassword(hashPassword(adminForm.getPassword())); //hashing password
		admin.setFirstName(adminForm.getFirstName());
		admin.setLastName(adminForm.getLastName());
		
	
		
		
		
		adminDao.createAdmin(admin);
		return "admin/adminHome";
	}
	
	
//	@GetMapping("/login")
//	public String login() {
//		
//	    
//		
//		return "admin/adminLogin";
//	}
	
	
	
	
	
	//password hashing
	private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
	
}