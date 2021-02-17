package com.Itma.model;

import java.util.List;

public interface IAdminDao {


	Admin createAdmin(Admin admin);
	Admin fetchById(int id);
	Admin fetchByEmail(String email);
	List<Admin> fecthByFirstName(String firstName);
	Admin createAdmin();
	
	//Admin fetchByPhoneNo(int phoneNo);
	
}
