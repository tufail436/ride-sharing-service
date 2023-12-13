package com.fangfei.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	@Column(name="id")
	int id;
	
	
	
	@Column(name="firstname")
    String firstName;
	
	@Column(name="lastname")
    String secondName;
	
	@Column(name="password")
    String Password;
	

	@Column(name="ratting")
    double Rating;
	
	@Column(name="phone")
	String phone;
     
	
	public Passenger(){
		
	}

	
	public Passenger(int id,String firstName, String secondName,String Password,double  rating,String phone )
	{
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.Password = Password;
		this.Rating = rating;
		this.phone = phone;
	
		
	}
	
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
    public double getRating() {
	return Rating;
	
	}
	public void setRating(double rating) {
		this.Rating = rating;
	}
	
	     
	 
}
