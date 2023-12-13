package com.fangfei.springboot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.Services.TripService;
import com.fangfei.springboot.beans.Trip;
import com.fangfei.springboot.model.singInModel;


@RestController
public class TripManagementController {
	
	@Autowired
	TripService tripService;
	
	@GetMapping("/getBill/{id}")  
	public APIResponse setBill(@PathVariable(value="id")int id) {
		return tripService.setBill(id);
	}
	@PostMapping("/signIn")  
	public APIResponse signIn(@RequestBody singInModel model) {
		return tripService.signIn(model); 
	 }
	
	 @GetMapping("/AllActiveTrip/{Status}")  
	 public  List<Trip> chcekAllActiveTrip(@PathVariable(value="Status") String Status) {
		 
		 return tripService.chcekAllActiveTrip(Status);
		 
	 }

}
