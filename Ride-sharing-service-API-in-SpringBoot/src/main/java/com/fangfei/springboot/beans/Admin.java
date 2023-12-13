package com.fangfei.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="admin")
public class Admin {
	
	
	public Admin (){
		  
		}
	
	@Id
    @Column(name = "idadmin")
	int id;
	 
	 
	@Column(name = "type")
	String personType;
	
	@Column(name = "fname")
	String firstName;
	
	@Column(name = "lname")
	String lastName;
	
	@Column(name = "password")
	String Password;
	
	@Column(name = "phone")
	String phoneNumber;
	
	
	
	public Admin( int id,String personType,String firstName,String lastName,String password, String phoneNumber ) {
		this.id = id;
		this.personType = personType;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.Password = password;
    	this.phoneNumber = phoneNumber;
		
		
		
	}
	
    

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
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
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	
	


}
