package com.Itma.model;

import java.util.List;

public interface IUserDao {
	
	
	User createUser(User user);
	User fetchById(int id);
	User fetchByEmail(String email);
	List<User> fecthByFirstName(String firstName);
	List<User> fetchByLocation(String location);
	User fetchByPhoneNo(int phoneNo);
	
	UserInformation fetchUserInformation(String email);
	UserInformation setUserInformation(UserInformation info);
	
	List<UserDiagnostics> fetchDiagnostics(String email);
	
	List<UserDoctorAppointment> fetchAppointment(String email);
	
	UserDoctorAppointment submitAppointment(UserDoctorAppointment appointment);

}
