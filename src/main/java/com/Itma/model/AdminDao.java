package com.Itma.model;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Itma.repository.AdminRepository;

@Service
public class AdminDao implements IAdminDao {
	@Autowired
	AdminRepository adminRepository;
	
	

	@Override
	public Admin createAdmin() {
		
	    Admin admin = new Admin();
		admin.setFirstName("firstName");
		admin.setLastName("lastName");
		admin.setPassword("0x888912130932jaeoj");
		
		adminRepository.save(admin);
		
		return admin;
	}

	@Override
	public Admin fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin fetchByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> fecthByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}


}
