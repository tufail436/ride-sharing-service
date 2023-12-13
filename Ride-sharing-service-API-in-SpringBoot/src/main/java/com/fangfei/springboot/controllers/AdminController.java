package com.fangfei.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.Services.AdminServices;
import com.fangfei.springboot.beans.Admin;
import com.fangfei.springboot.beans.Trip;


@RestController
public class AdminController {

	@Autowired
	AdminServices adminservice;
	
	@GetMapping("/getusers")
	
	public List<Admin> getusers() {
		
		return adminservice.getAllAdmin();
	}
	
	@PostMapping("/adduser")
	public APIResponse AddUsers(@RequestBody Admin admin) {
		
	    return adminservice.AddUsers(admin);
	}
	
	@GetMapping("/getusers/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value="id")int id) {
		try {
		Admin admin = adminservice.getAdminbyID(id);
		
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
				
		}
		catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			
		}
	}
	
	@GetMapping("/getuser/usertype")
	public List<Admin> getUserByType(@RequestParam(value="type") String userType) {
		
			
			return adminservice.getUserbyType(userType);
					
	}
	
	@DeleteMapping("/deleteusers/{id}")
		
		public APIResponse deleteUser(@PathVariable(value="id") int id) {
	
			
		    return adminservice.deleteUsers(id);
		}

	
	

	
	
	
	
	

}
