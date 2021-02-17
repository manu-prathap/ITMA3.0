package com.Itma.model;




import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	

	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return email;
	}

	public void setAdminEmail(String adminEmail) {
		this.email = adminEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



}
