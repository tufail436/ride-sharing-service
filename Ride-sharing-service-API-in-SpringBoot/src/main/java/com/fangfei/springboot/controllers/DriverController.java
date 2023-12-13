package com.fangfei.springboot.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.Response.ApiResult;
import com.fangfei.springboot.Response.ResponseOrMessage;
import com.fangfei.springboot.Services.DriverService;
import com.fangfei.springboot.beans.Trip;
import com.fangfei.springboot.model.RequestPOJO;
import com.fangfei.springboot.model.SetGradeModel;





@RestController
public class DriverController {
	
	
	@Autowired
	DriverService driverservice;
	
	
	@GetMapping("/getDriverActiveTrip/{id}")     
	public ResponseOrMessage<Trip> getCurrentTrip(@PathVariable(value="id")int id) {		
		return driverservice.getCurrentTrip(id);
	}
	
	 @GetMapping("/takeTrip/{id}")
	 public APIResponse takeTrip(@PathVariable(value="id") int id) {
	     return driverservice.takeTrip(id);
	 }
	 
	 @PostMapping("/endTrip")
	 public APIResponse endTrip(@RequestBody SetGradeModel model)
	  {
	    
	        return driverservice.endTrip(model);
	  }
	 
	
	 
	 
	 
	 
} 
	
	