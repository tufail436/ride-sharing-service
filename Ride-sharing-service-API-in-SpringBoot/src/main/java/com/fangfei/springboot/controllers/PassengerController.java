package com.fangfei.springboot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.Response.ApiResult;
import com.fangfei.springboot.Response.ResponseOrMessage;
import com.fangfei.springboot.Services.PassengerServices;
import com.fangfei.springboot.beans.Admin;
import com.fangfei.springboot.beans.Trip;
import com.fangfei.springboot.model.GiveRateDriverModel;
import com.fangfei.springboot.model.SetGradeModel;
import com.fangfei.springboot.model.SetRequestCarModel;

@RestController
public class PassengerController {
	
	
		@Autowired
		PassengerServices  passengerservice;
		
	   
	 
		   
		@GetMapping("/getActiveTrip/{id}")     
		public APIResponse getActiveTrip(@PathVariable(value="id")int id) {		
		    return passengerservice.getActiveTrip(id);
		}
	
	    
		@PostMapping("/requestCar")
		public APIResponse requestCar(@RequestBody SetRequestCarModel model) {
		    return passengerservice.requestCar(model);
		}	
		
		
			
		@GetMapping("/denyTrip/{id}")     
		public APIResponse denyTrip(@PathVariable(value="id")int id) {		
		    return passengerservice.denyTrip(id);
		}
		

	    @PostMapping("/giveRate")
	    public APIResponse giveRateDriver(@RequestBody GiveRateDriverModel  model) {
	        return  passengerservice.giveRateDriver(model);
	    }
	
	    
	

}
