package com.Itma.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
		
		@Column(name = "dob")
		private Date dob;
		
		@Column(name = "rate")
		private BigDecimal rate;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "enabled")
		private Integer enabled;
		
		@OneToMany(targetEntity = DoctorSpecialization.class,cascade = CascadeType.ALL)
	    @JoinColumn(name ="doctor_email",referencedColumnName = "doctor_email")
		private List<DoctorSpecialization> doctorSpecialization ;




		public List<DoctorSpecialization> getDoctorSpecialization() {
			return doctorSpecialization;
		}

		public void setDoctorSpecialization(List<DoctorSpecialization> doctorSpecialization) {
			this.doctorSpecialization = doctorSpecialization;
		}

		public Doctor(String doctor_email, String password, Integer phone_number, String first_name, String last_name,
				Date dob, BigDecimal rate, String address, Integer enabled) {
			super();
			this.doctor_email = doctor_email;
			this.password = password;
			this.phone_number = phone_number;
			this.first_name = first_name;
			this.last_name = last_name;
			this.dob = dob;
			this.rate = rate;
			this.address = address;
			this.enabled = enabled;
		}

		public Doctor() {
		}

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

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
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

		public Integer getEnabled() {
			return enabled;
		}

		public void setEnabled(Integer enabled) {
			this.enabled = enabled;
		}
		
		@Override
		public String toString() {
			return "Employee [doctor_email=" + doctor_email + ", password=" + password + ", phone_number=" + phone_number + ", first_name=" + first_name
					+ ", last_name=" + last_name + ", dob=" + dob + ", rate" + rate + ", address="
					+ address + ", enabled=" + enabled +"]";
		}
		
		
}
