package com.Itma.controller;

import java.io.IOException;

import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Itma.model.User;
import com.Itma.model.UserDao;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	
	
	@GetMapping("/register")
	public String register(Map<String, Object> model) {
        model.put("userForm", new User());
		return "user/userRegister";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam("id") MultipartFile multipartFile, User userForm) throws IOException {
		
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setPhoneNo(userForm.getPhoneNo());
		user.setPassword(hashPassword(userForm.getPassword())); //hashing password
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setDob(userForm.getDob());
		//Address 
		user.setLocationStreet(userForm.getLocationStreet());
		user.setDistrict(userForm.getDistrict());
		user.setState(userForm.getState());
		user.setCountry(userForm.getCountry());
		user.setPinCode(userForm.getPinCode());
		
		//uploading ID Document scan
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		user.setIdDoc(fileName);
		String uploadDir = "/uploads/user";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);  //add throw and catch to redirect for upload failure
		
		userDao.createUser(user);
		return "user/userHome";
	}
	
	
	@GetMapping("/login")
	public String login() {
		
	    
		
		return "user/userLogin";
	}
	
	
	
	
	
	//password hashing
	private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
	
}
