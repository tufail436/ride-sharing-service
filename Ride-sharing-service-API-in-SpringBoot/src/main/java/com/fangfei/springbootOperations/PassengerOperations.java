package com.fangfei.springbootOperations;

import java.util.HashMap;

import com.fangfei.springboot.beans.Passenger;

public class PassengerOperations {
	
	static HashMap<Integer,Passenger>  passengerIdMap;
	
	
	public PassengerOperations() {
		
		passengerIdMap =new HashMap<Integer,Passenger>();
		
	
		
	}
}

