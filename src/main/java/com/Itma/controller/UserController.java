package com.Itma.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Itma.model.Doctor;
import com.Itma.model.DoctorDao;
import com.Itma.model.HibernateSearchClass;
import com.Itma.model.User;
import com.Itma.model.UserDao;
import com.Itma.model.UserDetails;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	HibernateSearchClass hibernateSearch;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	
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
		user.setPassword(encoder.encode(userForm.getPassword())); //hashing password
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
	public String login(Map<String, Object> model) {
		
		
		User user = userDao.fetchById(1);
		String name = user.getFirstName();
		
		HttpSession session = httpSessionFactory.getObject();
		
		
		
		model.put("name", name);
		model.put("user", user);
		
		session.setAttribute("user", user);
		
		return "user/userHome";
	}
	
	@PostMapping("/loginsuccess")
	public String loginSuccess(/*@RequestParam("email") String email,*/ Map<String, Object> model){
		
//		System.out.println(email);
//		User user = userDao.fetchByEmail(email);
		
		
//		String name = user.getFirstName();
//		
//		System.out.println(name);
//		model.put("name", name);
//		
//		model.put("user", user);
		
		return "user/userHome";
	}
	

	
	@GetMapping("/search")
//	@ResponseBody
//	@ResponseStatus(HttpStatus.OK)
	public String search(@RequestParam(value = "query", required = false) String searchTerm, HttpSession session, Map<String, Object> model) {
		
		List<Doctor> searchResults = null; 
		
		try {
			
			searchResults = hibernateSearch.fuzzySearch(searchTerm);
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	    model.put("doctors",searchResults);
	    
		User user = (User) session.getAttribute("user");
		
		System.out.println(user.getFirstName());
		
	    model.put("user", user);
	    model.put("name", user.getFirstName());
	    //return model;
	    
		return "user/userHome";
	} 
	
	
	@GetMapping("/details")
	
	public String viewDetails(@RequestParam(value = "id", required = true) int id, HttpSession session, Map<String, Object> model) {
		
		Doctor doctor = doctorDao.fetchByIntId(id);
		User user = (User) session.getAttribute("user");
		
		
		model.put("doctor", doctor);
		model.put("name", user.getFirstName());
		model.put("user", user);
		
		
	    
		return "user/userDoctorDetails";
		
	}
	
	@GetMapping("/userdetails")
	
	public ModelAndView viewUserDetails(HttpSession session, Map<String, Object> model) {
		
		User user = (User) session.getAttribute("user");
		
		
		UserDetails details = userDao.fetchUserDetails(user.getEmail());
		
		model.put("details", details);
		model.put("name", user.getFirstName());
		
		double height = details.getHeight();
		double weight = details.getWeight();
		
		double bmi = weight/(height)*(height);
		
		model.put("user", user);
		model.put("bmi", bmi);
		
		
		return new ModelAndView("redirect: /details");  //ModelAndView 
	}
	
	
	@PostMapping("detailsUpdate")
	public String updateDetails(HttpSession session, 
			@RequestParam("height") double height,
			@RequestParam("weight") double weight,
			@RequestParam("bloodgroup") String bloodGroup,	
			@RequestParam("profession") String profession,
			Map<String, Object> model) {
		
		User user = (User) session.getAttribute("user");
		
		UserDetails details = userDao.fetchUserDetails(user.getEmail());
		
		details.setHeight(height);
		details.setWeight(weight);
		details.setProfession(profession);
		details.setBloodGroup(bloodGroup);
		details.setUser(user);
		
		return "user/userDetails";
		
	}
	
	
	

}
