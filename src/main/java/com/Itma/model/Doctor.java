package com.Itma.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;




@Indexed
@Entity
public class Doctor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Field
	private String doctorEmail;
	
	
	private String password ;
	
	@Column(nullable = false)
	private long phoneNumber;
	
	
	@Field
	private String firstName;
	
	@Field
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Field
	private String streetAddress;
	
	
	@ContainedIn
	@OneToMany(mappedBy = "doctor")
	private List<DoctorSpecialization> specializations;
	
	@OneToMany(mappedBy = "doctor")
	private List<UserDiagnostics> userDiagnostics;
	
	
	
	
	public List<UserDiagnostics> getUserDiagnostics() {
		return userDiagnostics;
	}

	public void setUserDiagnostics(List<UserDiagnostics> userDiagnostics) {
		this.userDiagnostics = userDiagnostics;
	}

	public List<DoctorSpecialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(List<DoctorSpecialization> specializations) {
		this.specializations = specializations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Field
	private String district;
	
	@Field
	private String state;
	
	@Field
	private String country;
	
	@Field
	private int pinCode;

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	

	}