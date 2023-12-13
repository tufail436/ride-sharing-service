package com.fangfei.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="billing")
public class Billing {
	
	@Id
	@Column(name = "idbilling")
	int id;
	
	
	@Column(name = "pid")
	int pid;
	
	
	@Column(name = "did")
	int did;
	
	@Column(name = "start_address")
	String start_address;
	
	@Column(name = "end_address")
	String end_address;
	
	@Column(name = "distance")
	double distance;
	
	@Column(name = "bill")
	double bill;
	
	public Billing() {
		
		
	}
	
	
	public Billing(int id, int pid, int did, String start_address, String  end_address, double distance , double bill) {
		
		this.id = id;
		this.pid = id;
		this.did = id;
		this.start_address = start_address;
		this.end_address = end_address;
		this.distance = distance;
		this.bill = bill;
		
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

	public void setDid(int did) {
		this.did = did;
	}

	public String getStart_address() {
		return start_address;
	}

	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}

	public String getEnd_address() {
		return end_address;
	}

	public void setEnd_address(String end_address) {
		this.end_address = end_address;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
	
	
}
	
	
	



	
	
	
