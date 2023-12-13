package com.fangfei.springboot.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.beans.Driver;
import com.fangfei.springboot.beans.Passenger;
import com.fangfei.springboot.beans.Trip;
import com.fangfei.springboot.model.GiveRateDriverModel;
import com.fangfei.springboot.model.SetGradeModel;
import com.fangfei.springboot.model.SetRequestCarModel;
import com.fangfei.springboot.repositories.AdminRepository;
import com.fangfei.springboot.repositories.DriverRepository;
import com.fangfei.springboot.repositories.PassengerRepository;
import com.fangfei.springboot.repositories.TripRepository;



@Component
@Service
public class PassengerServices {
	
	@Autowired
    DriverRepository driverRepository;
	
    @Autowired
    PassengerRepository passengerRepository;
   
    
	
	@Autowired
	AdminRepository adminrep;
	
	@Autowired
	TripRepository tripRepository;
	

	
	
	
	//Request for a Car
	
	public APIResponse requestCar(SetRequestCarModel model) {

        Trip trip  = tripRepository.findBypid(model.getPid()).orElse(null);
        
        if(trip !=null) {
        	
        if (trip.getStatus().equalsIgnoreCase("CREATE")) {
        	APIResponse res = new APIResponse();
     		res.setMsg("U already have active trip, u can't request to car the same time");
     		return res;	
        }
        
        
        else {
        	
        	int id = model.getPid();
        	  Passenger passenger = passengerRepository.findById(id).orElseGet(null);

              if (passenger == null) {
              	APIResponse res = new APIResponse();
           		res.setMsg("Client doesnt exist");
           		return res;	
            }
        	
        	 
        	 Trip trip1 = new Trip();
        	 trip1.setId(getMaxIdTrip());
        	 trip1.setPid(model.getPid());
        	 trip1.setDid(model.getDid());
        	 trip1.setStatus("CREATE");
             trip1.setStart_address(model.getStart_address());
             trip1.setFinish_address(model.getFinish_address());
             trip1.setRating(model.getRating());
             tripRepository.save(trip1);
             APIResponse res = new APIResponse();
             res.setMsg("The trip was created. Wait for a response.");
             return res;
        }
      
        }
        
        else{
        	
        	Trip trip1 = new Trip();
	       	 trip1.setId(getMaxIdTrip());
	       	 trip1.setPid(model.getPid());
	       	 trip1.setDid(model.getDid());
	       	 trip1.setStatus("CREATE");
            trip1.setStart_address(model.getStart_address());
            trip1.setFinish_address(model.getFinish_address());
            trip1.setRating(model.getRating());
            tripRepository.save(trip1);
            APIResponse res = new APIResponse();
            res.setMsg("The trip was created. Wait for a response.");
            return res;
        }
        	
  }

       
       
   
	public int getMaxIdTrip() 
	{
		return tripRepository.findAll().size()+1;
	}
	
	
	 public APIResponse giveRateDriver(GiveRateDriverModel model) {
	        Trip trip = tripRepository.findById(model.getId()).orElse(null);
	      
	        
	     

	        if (trip == null) {
	        	APIResponse res = new APIResponse();
	            res.setMsg("Trip doesnt exist");
	            return res;
	        }

	        if (!trip.getStatus().equalsIgnoreCase("FINISH")) {
	         
	            APIResponse res = new APIResponse();
	            res.setMsg("Trip not finished");
	            return res;
	        }
	        
	      
	        Driver driver = driverRepository.findById(trip.getDid()).orElse(null);

	        if (driver == null) {
	          
	            APIResponse res = new APIResponse();
	            res.setMsg("Driver not found");
	            return res;
	        }

	        driver.setRatting((driver.getRatting() + (double) model.getTriprate()) / 2);
	        trip.setRating(String.valueOf(model.getTriprate()));     
	        driverRepository.save(driver);
	        tripRepository.save(trip);
	        
	        APIResponse res = new APIResponse();
            res.setMsg("Thank you for rating");
            return res;
	     
	    }
	 
	 
	 public  APIResponse denyTrip(int clientId) {
		 
	            Trip trip = tripRepository.findBypid(clientId).get();
	            
	            if (trip == null) {
	            	APIResponse res = new APIResponse();
	                res.setMsg("Trip doesnt exist");
	                return res;
	            	
	            }
	            
	            else {
	            trip.setStatus("DENY");
	            tripRepository.save(trip);
	            APIResponse res = new APIResponse();
                res.setMsg("The trip was canceled");
                return res;
	         
	            }   
	            
	         

	    }
	    
	      public APIResponse getActiveTrip(int passengerId) {
	    	
	    	 Trip trip = tripRepository.findBypid(passengerId).orElse(null);
	    	  
	    	 if (trip == null) {	    		 
		            APIResponse res = new APIResponse();
	                res.setMsg("Wrong parameter");
	                return res;
	    		   
	               } 
	    	 
	    	 
	    	 else {
	    		 String status1 = trip.getStatus();
	                

		            if (status1.equalsIgnoreCase("FINISH")) {
		            	APIResponse res = new APIResponse();
		                res.setMsg("Client does not have active trips");
		                return res;
		              }
		            else if(status1.equalsIgnoreCase("CREATE") ) {
		            	APIResponse res = new APIResponse();
		                res.setMsg("Your Trip is  CREATE Succesfully");
		                return res;
		            }
		            else if(status1.equalsIgnoreCase("START") ) {
		            	APIResponse res = new APIResponse();
		                res.setMsg("Your Trip is  START Succesfully");
		                return res;
		            }
		            
		            else {
		            	
		            	APIResponse res = new APIResponse();
		                res.setMsg("Your Trip is DENEY");
		                return res;
		            	
		            }
	    		 
	    		 
	    	 }
	    	 
	    
	        }
	    
	    
	   
	    
	
	

}
