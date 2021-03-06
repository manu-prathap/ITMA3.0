package com.Itma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Itma.repository.UserDiagnosticsRepository;
import com.Itma.repository.UserInformationRepository;
import com.Itma.repository.UserRepository;

@Service
public class UserDao implements IUserDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserInformationRepository infoRepository;
	
	@Autowired
	UserDiagnosticsRepository diagnostics;
	
	
	
	@Override
	public User createUser(User user) {
		
//		User user = new User();
//		user.setFirstName("firstName");
//		user.setLastName("lastName");
//		user.setPhoneNo(89900012);
//		user.setPassword("0x888912130932jaeoj");
		
		userRepository.save(user);
		
		return user;
	}

	@Override
	public User fetchById(int id) {
		
		User user = userRepository.findByuserId(id);
		
		return user;
	}

	@Override
	public User fetchByEmail(String email) {
		User user = userRepository.findByemail(email);
		return user;
	}

	@Override
	public List<User> fecthByFirstName(String firstName) {
		List<User> users = userRepository.findByfirstName(firstName);
		return users;
	}

	@Override
	public List<User> fetchByLocation(String location) {
		List<User> users = userRepository.findBylocationStreet(location);
		return users;
	}

	@Override
	public User fetchByPhoneNo(int phoneNo) {
		User user = userRepository.findByphoneNo(phoneNo);
		return user;
	}
	
	@Override
	public UserInformation fetchUserInformation(String email) {
		
		UserInformation information = infoRepository.findByuserEmail(email);
		
		return information;	   
		
		
	}
	
	@Override
public UserInformation setUserInformation(UserInformation info) {
		
		infoRepository.save(info);
		
		
		return null;
	}
	
@Override
public List<UserDiagnostics> fetchDiagnostics(String email){
	
	   List<UserDiagnostics> diagnosticList = diagnostics.findByuserEmail(email);
	
	   return diagnosticList;
	
}

}
