package com.fangfei.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trip")
public class Trip {
	
	@Id
	@Column(name="id")
	int id;
	
	
	@Column(name="pid")
	int pid;
	
	@Column(name="did")
	int did;
	
	
	@Column(name="status")
	String status;
	
	@Column(name="start_address")
	String start_address;
	
	@Column(name="finish_address")
	String finish_address;
	
	@Column(name="rating")
	String rating;
	
	@Column(name="triprate")
	Double  triprate;
	
	public Trip() {
		
	}
	
	public Trip(int id, int pid,int did, String status, String start_address, String finish_address, String rating,Double triprate)
	{
		
		this.id = id;
		this.pid = pid;
		this.did = did;
		this.status = status;
		this.start_address= start_address;
		this.finish_address= finish_address;
		this.rating = rating;
		this.triprate = triprate;
	
		
		
		
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int  did) {
		this.did = did;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStart_address() {
		return start_address;
	}

	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}

	public String getFinish_address() {
		return finish_address;
	}

	public void setFinish_address(String finish_address) {
		this.finish_address = finish_address;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Double getTriprate() {
		return triprate;
	}

	public void setTriprate(Double triprate) {
		this.triprate = triprate;
	}


	
	

}
