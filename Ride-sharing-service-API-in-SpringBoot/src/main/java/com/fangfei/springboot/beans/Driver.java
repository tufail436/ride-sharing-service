package com.fangfei.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="driver")
public class Driver {
	
	@Id
	@Column(name = "id")
	int Did;
	
	@Column(name = "firstname")
	String firstName;
	
	@Column(name = "lastname")
	String lastName;
	
	@Column(name = "password")
	String Password;
	

	
	@Column(name = "status")
	String status;
	
	@Column(name = "ratting")
	Double ratting;
	
	@Column (name = "phone")
	
	String phone;
	

	
    public Driver(int Did,String firstName,String lastName,String password, String status,Double ratting,String phone) {
    	this.Did = Did;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.Password = password;
    	this.ratting = ratting;
    	this.status = status;
    	this.phone = phone;
    	
  
    	
    }
	
	
	
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getStatus() {
		return getStatus();
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

	public Double getRatting() {
		return ratting;
	}



	public void setRatting(Double ratting) {
		this.ratting = ratting;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public Driver() {
		
	}


	

   
}
