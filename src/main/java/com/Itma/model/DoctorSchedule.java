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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "schedule")
public class DoctorSchedule {
	
	@Id
    @GeneratedValue
    private Long scheduleId;	

	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private String dayOfWeek;
	
	@Column(name = "startTime")
	private Time startTime;
	
	@Column(name = "endTime")
	private Time endTime;
	
	@Column(name = "consultationFee")
	private long consultationFee;
	
	@Column(name = "isAvailable")
	private boolean isAvailable;
	
	@Column(name = "maxCapacity")
	private int maxCapacity;
	
	
	@ManyToOne
	@JoinColumn(name="doctorEmail", referencedColumnName = "doctorEmail", nullable = false)
	Doctor doctor;
	
	
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	


	public Long getScheduleId() {
		return scheduleId;
	}

	public void setSchedule_id(Long schedule_id) {
		this.scheduleId = schedule_id;
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

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	

	
}
