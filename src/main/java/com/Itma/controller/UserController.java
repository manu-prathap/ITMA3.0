package com.Itma.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.LocalDate;
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
import org.springframework.web.servlet.view.RedirectView;

import com.Itma.model.Doctor;
import com.Itma.model.DoctorDao;
import com.Itma.model.DoctorSchedule;
import com.Itma.model.HibernateSearchClass;
import com.Itma.model.User;
import com.Itma.model.UserDao;
import com.Itma.model.UserDoctorAppointment;
import com.Itma.model.UserInformation;


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
	public String login(String email, Map<String, Object> model) {
		
		email = "bugsbunny@email.com";
		User user = userDao.fetchByEmail(email);
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
	
	public String viewUserDetails(HttpSession session, Map<String, Object> model) {
		
		User user = (User) session.getAttribute("user");
		
		
		UserInformation info = userDao.fetchUserInformation(user.getEmail());
		
		if(info!=null) {
		
		model.put("details", info);        //details is info for the view jsp
		
		
		double height = info.getHeight();
		double weight = info.getWeight();
		
		double bmi = ((weight/(height*height))*10000);
		
		
	
		model.put("bmi", bmi);	
		
		}
		model.put("name", user.getFirstName());
		model.put("user", user);
		return "user/userDetails";  //View 
	}
	
	
	@PostMapping("/detailsUpdate")    //updating of user details
	public void updateDetails(HttpSession session, 
			@RequestParam(value = "height") double height,
			@RequestParam(value = "weight") double weight,
			@RequestParam(value = "bloodgroup") String bloodGroup,	
			@RequestParam(value = "profession") String profession,
			Map<String, Object> model,
			HttpServletResponse response) throws IOException {
		
		User user = (User) session.getAttribute("user");
		
		UserInformation info = userDao.fetchUserInformation(user.getEmail());
		
		if(info == null) {
			
			info = new UserInformation();
			
		}
		
		
		info.setHeight(height);
		info.setWeight(weight);
		info.setProfession(profession);
		info.setBloodGroup(bloodGroup);
		info.setUser(user);
		userDao.setUserInformation(info);
		
		//viewUserDetails(session, model); //redirect to previous handler ^^^
		
		response.sendRedirect("userdetails");
		
		//return "redirect: userdetails";
	
	}
	
	//View schedules of doctor
	@GetMapping("/schedules")
	public String viewDoctorSchedule(@RequestParam(value = "id")int id,
			                         HttpSession session, 
			                         Map<String, Object> model){
	      
		           Doctor doctor = doctorDao.fetchByIntId(id);
		           List<DoctorSchedule> scheduleList = doctorDao.fetchDoctorSchedule(doctor.getDoctorEmail());        
		           
//		           DoctorSchedule sched = scheduleList.get(0);
//		           System.out.println(sched.getDayOfWeek());
		           model.put("scheduleList", scheduleList);
		           model.put("doctor", doctor);
		           
		        
		            return "user/userDoctorScheduleView";

          }
	
	//Booking appointment -> add to appointment table
	@GetMapping("/bookappointment")
    public String bookAppointment(@RequestParam(value = "id")int scheduleId, 
    		                      HttpSession session,
    		                      Map<String, Object> model,
    		                      UserDoctorAppointment appointment) {
		
		User user = (User)session.getAttribute("user");
		DoctorSchedule schedule = doctorDao.fetchScheduleById(scheduleId);
		Doctor doctor = schedule.getDoctor();
		
		LocalDate date = LocalDate.now();
		Date sqlDate = Date.valueOf(date.toString());
		
		LocalDate appDate = dayCalculator(date,schedule.getDayOfWeek());  //method at end of Controller
		Date sqlAppDate = Date.valueOf(appDate.toString());
		
		appointment.setBookedDate(sqlDate);
		appointment.setAppDate(sqlAppDate);
		
		appointment.setDoctor(doctor);
		appointment.setSchedule(schedule);
		appointment.setUser(user);
		appointment.setUserStatus(true);
		appointment.setDoctorStatus(true);
		
		
		userDao.submitAppointment(appointment);
		
		
		return "user/userHome";
		
	} 
	
	//Viewing appointment
	
	@GetMapping("/viewappointments")
	public String viewAppointment(Map<String, Object> model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		List<UserDoctorAppointment> appointments = userDao.fetchAppointment(user.getEmail());
		
		model.put("appointments", appointments);
		
		model.put("user",user);
		
		model.put("name", user.getFirstName());
		
		
		
		return "user/userAppointments" ;
	}
	
	//obtain day of week based on the appointment booking date
	private LocalDate dayCalculator(LocalDate date, String day) {
		
		String days[] = {"Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		
		int i = 0;
		
		//System.out.println(days[ date.plusDays(i).getDayOfWeek() ]);
		
		for(i=0; i<5; i++) {
			
			if( day == days[ date.plusDays(i-1).getDayOfWeek() ] ) break;
			
		}
		
		
		return date.plusDays(i);
	}
	
}
