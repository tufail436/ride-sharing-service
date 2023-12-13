package com.fangfei.springboot.Services;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.beans.Admin;
import com.fangfei.springboot.beans.Billing;
import com.fangfei.springboot.beans.Trip;
import com.fangfei.springboot.repositories.AdminRepository;
import com.fangfei.springboot.repositories.BillingRepository;
import com.fangfei.springboot.repositories.DriverRepository;
import com.fangfei.springboot.repositories.PassengerRepository;
import com.fangfei.springboot.repositories.TripRepository;
import com.fangfei.springboot.model.singInModel;

@Component
@Service
public class TripService {
	

	@Autowired
    DriverRepository driverRepository;
	
    @Autowired
    PassengerRepository passengerRepository;
   
    
	
	@Autowired
	AdminRepository adminrep;
	
	@Autowired
	TripRepository tripRepository;
	

	@Autowired
	BillingRepository billingRepository;
	
	double price;
	
	 public APIResponse setBill(int tripID) {
		 
		 Trip trip = tripRepository.findById(tripID).orElse(null); 
		 
		 if(trip == null) {
			 APIResponse res = new APIResponse();
	     	res.setMsg("Trip not found");
	     	return res; 
		 }
		 
		 else {
		 int passengerId= trip.getPid();
		 int driverId=trip.getDid(); 
		 String start_address= trip.getStart_address();
		 String finish_address = trip.getFinish_address();
		 String tripType = trip.getRating();
		 
		 System.out.println(tripType);
		 
		 Random distance = new Random();
		 double distance1 = 50 + (1000 - 50) * distance .nextDouble();
		
		        if(tripType.equalsIgnoreCase("ECONOMY")) {
		        	price=distance1+ 5.0;
		        }
		        
		        else if(tripType.equalsIgnoreCase("COMFORT")) {
		        	price=distance1+ 10.0;
		        }
		        
		        else if(tripType.equalsIgnoreCase("LUX")) {
		        	price=distance1+ 15.0;
		        }
		        
		        else if(tripType.equalsIgnoreCase("GOLD")) {
		        	price=distance1+ 10.0;
		        }
		        else {
		        	price=distance1+ 0;
		        }
		        
		    	 
		 Billing billing = new Billing(getMaxIdBilling() ,passengerId,driverId,start_address,finish_address,distance1,price );
		 billingRepository.save(billing);
		 
		 APIResponse res = new APIResponse();
  		 res.setMsg("Total bill of this trip is "+price);
  		 return res;
		 }
		  
	 }
	 
	 public int getMaxIdBilling() 
		{
			return billingRepository.findAll().size()+1;
		}
	
	
	 public  List<Trip> chcekAllActiveTrip(String Status) {
	
			 return tripRepository.findBystatus(Status); 
	 }
	
	
	
	
	 public APIResponse signIn(singInModel model) {
		 
			Admin admin = adminrep.findByphoneNumber(model.getPhone()).orElse(null);
			APIResponse res = new APIResponse();
			if(admin == null  ) {
	        	
	     		res.setMsg("User not found");
	     		return res;
	        	
	        }	
			else {
				String password1 = admin.getPassword();
				
				if(model.getPassword().equals(password1)) {
		     		res.setMsg("User Login Succesful");
		     		return res;
					
				}
				
				else {
					
		     		res.setMsg("PAssword is wrong" );
		     		return res;
				}
				
				
			}
		 
	 }
	 
	 
	 
	


}
