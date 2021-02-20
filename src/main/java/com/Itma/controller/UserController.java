package com.Itma.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
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

import com.Itma.model.Doctor;
import com.Itma.model.HibernateSearchClass;
import com.Itma.model.User;
import com.Itma.model.UserDao;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	HibernateSearchClass hibernateSearch;
	
	
	
	@GetMapping("/register")
	public String register(Map<String, Object> model) {
        model.put("userForm", new User());
		return "user/userRegister";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam("id") MultipartFile multipartFile, User userForm) throws IOException, ParseException {
		
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
		String uploadDir = "uploads/user";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);  //add throw and catch to redirect for upload failure
		
		userDao.createUser(user);
		return "index";
	}
	
	
	@GetMapping("/login")
	public String login(String email, Map<String, Object> model) {
		
		User user = userDao.fetchByEmail("bugsbunny@email.com");
		String name = user.getFirstName();
		
		model.put("name", name);
		model.put("user", user);
		
		return "user/userHome";
	}
	
	@PostMapping("/loginsuccess")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password){
		
		User user = userDao.fetchByEmail(email);
		if(password==user.getPassword()) {
			
		}
		
		
		return "user/userHome";
	}
	

	
	@GetMapping("/search")
	public String search(@RequestParam(value = "query", required = false) String searchTerm, Map<String, Object> model) {
		
		List<Doctor> searchResults = null; 
		
		try {
			
			searchResults = hibernateSearch.fuzzySearch(searchTerm);
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	    model.put("doctors",searchResults);
		
		return "user/userHome";
	} 
	
	
	//password hashing
	private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
	
}
