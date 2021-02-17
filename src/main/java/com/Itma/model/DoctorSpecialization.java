package com.Itma.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctorspecialization")
public class DoctorSpecialization {
	
	@Id
    @GeneratedValue
    private Long id;

	@ManyToOne
	@JoinColumn(name = "doctor_email")
	private Doctor doctor;
		
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "file_size")
	private String fileSize;
	
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	public DoctorSpecialization()
	{
		
	}

	public DoctorSpecialization( Long id,Doctor doctor, String specialization, String fileName, String filePath,
			String fileType, String fileSize, Timestamp createdDate) {
		super();
		this.id=id;
		this.doctor = doctor;
		this.specialization = specialization;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.createdDate = createdDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

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


	@Override
	public String toString() {
		return "DoctorSpecialization [id=" + id + ", doctor=" + doctor + ", specialization=" + specialization
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", fileType=" + fileType + ", fileSize="
				+ fileSize + ", createdDate=" + createdDate + "]";
		}
		

	}


