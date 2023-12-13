package com.fangfei.springboot.model;

public class SetRequestCarModel {
	
	
	String finish_address;
	int pid;
	int did;
	String rating;
	
	String Start_address;
	public String getStart_address() {
		return Start_address;
	}
	public void setStart_address(String start_address) {
		Start_address = start_address;
	}
	public String getFinish_address() {
		return finish_address;
	}
	public void setFinish_address(String finish_address) {
		this.finish_address = finish_address;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}


	

}
