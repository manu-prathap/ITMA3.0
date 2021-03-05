package com.Itma.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;


@Entity
@Indexed
@Embeddable
public class DoctorSpecialization{
	


	@Id
    @GeneratedValue
    private Long id;
	
	//String doctorEmail;
	@Field
	String specialization;
	
	@Column(nullable = false)
	private String fileName;
	
	@Column(nullable = false)
	private String filePath;
	
	@Column(nullable = false)
	private String fileType;
	
	@Column(nullable = false)
	private String fileSize;
	
	@Column(nullable = false)
	private Timestamp createdDate;
	
	
	@ManyToOne
	@JoinColumn(name="doctorEmail", referencedColumnName = "doctorEmail", nullable = false)
	@IndexedEmbedded
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getDoctorEmail() {
//		return doctorEmail;
//	}
//
//	public void setDoctorEmail(String doctorEmail) {
//		this.doctorEmail = doctorEmail;
//	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}