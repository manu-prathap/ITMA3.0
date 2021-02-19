package com.Itma.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class DoctorSchedule {
	
	@Id
    @GeneratedValue
    private Long schedule_id;
	
	@Column(name = "doctorEmail")
	private String doctorEmail;;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "startTime")
	private Time startTime;
	
	@Column(name = "endTime")
	private Time endTime;
	
	@Column(name = "consultationFee")
	private long consultationFee;
	
	@Column(name = "isAvailable")
	private String isAvailable;
	
	@Column(name = "maxCapacity")
	private int maxCapacity;
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Long getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Long schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public long getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(long consultationFee) {
		this.consultationFee = consultationFee;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	

	
}
	