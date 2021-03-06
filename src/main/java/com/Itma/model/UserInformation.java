package com.Itma.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class UserInformation implements Serializable {
	
   /**
    * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;	
	
private double height;
private double weight;
private String bloodGroup;
private String profession;

@OneToOne
@JoinColumn(name="email", referencedColumnName = "email", nullable = false )
User user;


@OneToOne
@JoinColumn(name="doctorEmail", referencedColumnName="doctorEmail", nullable = true)
Doctor doctor;

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public String getBloodGroup() {
	return bloodGroup;
}

public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}

public String getProfession() {
	return profession;
}

public void setProfession(String profession) {
	this.profession = profession;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	

}
