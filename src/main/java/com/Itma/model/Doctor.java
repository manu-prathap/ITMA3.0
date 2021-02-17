package com.Itma.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor {
	
		@Id
		@Column(name = "doctor_email")
		private String doctor_email;
		
		@Column(name = "password")
		private String password ;
		
		@Column(name = "phone_number")
		private Integer phone_number;
		
		@Column(name = "first_name")
		private String first_name;
		
		@Column(name = "last_name")
		private String last_name;
		
		//@DateTimeFormat(pattern = "MM-dd-yyyy")
		//@Column(name = "dob")
		//private Date dob;
		
		@Column(name = "rate")
		private BigDecimal rate;
		
		@Column(name = "address")
		private String address;
		
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
		
		private boolean enabled = true;

		public String getDoctor_email() {
			return doctor_email;
		}

		public void setDoctor_email(String doctor_email) {
			this.doctor_email = doctor_email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(Integer phone_number) {
			this.phone_number = phone_number;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public BigDecimal getRate() {
			return rate;
		}

		public void setRate(BigDecimal rate) {
			this.rate = rate;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
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

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		
		

}