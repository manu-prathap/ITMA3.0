package com.Itma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Itma.repository.UserRepository;

@Service
public class UserDao implements IUserDao {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User createUser() {
		
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setPhoneNo(89900012);
		user.setPassword("0x888912130932jaeoj");
		
		userRepository.save(user);
		
		return user;
	}

	@Override
	public User fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User fetchByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> fecthByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> fetchByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User fetchByPhoneNo(int phoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
