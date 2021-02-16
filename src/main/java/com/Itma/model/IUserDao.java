package com.Itma.model;

import java.util.List;

public interface IUserDao {
	
	
	User createUser();
	User fetchById(int id);
	User fetchByEmail(String email);
	List<User> fecthByFirstName(String firstName);
	List<User> fetchByLocation(String location);
	User fetchByPhoneNo(int phoneNo);
	
	
	
	

}
