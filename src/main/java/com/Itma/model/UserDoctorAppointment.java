package com.Itma.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserDoctorAppointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int appointmentId;
	
	
	@ManyToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "doctorEmail", referencedColumnName = "doctorEmail")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "scheduleId", referencedColumnName = "scheduleId")
	private DoctorSchedule schedule;

	private boolean userStatus;
	
	private boolean doctorStatus;
	
	
	
	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isDoctorStatus() {
		return doctorStatus;
	}

	public void setDoctorStatus(boolean doctorStatus) {
		this.doctorStatus = doctorStatus;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public DoctorSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(DoctorSchedule schedule) {
		this.schedule = schedule;
	}
	
	
	
	
}
