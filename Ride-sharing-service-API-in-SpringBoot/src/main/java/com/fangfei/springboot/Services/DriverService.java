package com.fangfei.springboot.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.Response.ResponseOrMessage;
import com.fangfei.springboot.beans.Driver;
import com.fangfei.springboot.beans.Passenger;
import com.fangfei.springboot.beans.Trip;
import com.fangfei.springboot.model.SetGradeModel;

import com.fangfei.springboot.repositories.AdminRepository;
import com.fangfei.springboot.repositories.DriverRepository;
import com.fangfei.springboot.repositories.PassengerRepository;
import com.fangfei.springboot.repositories.TripRepository;


@Component
@Service
public class DriverService {
	
	
	
	@Autowired
    DriverRepository driverRepository;
	
    @Autowired
    PassengerRepository passengerRepository;
   
    
	
	@Autowired
	AdminRepository adminrep;
	
	@Autowired
	TripRepository tripRepository;
	
	
	
	public APIResponse  takeTrip(int id) {
		
		Trip trip = tripRepository.findById(id).orElse(null);
		int did = trip.getDid();
		Driver driver = driverRepository.findById(did).orElse(null);
		
		if (driver == null) {
        	APIResponse res = new APIResponse();
     		res.setMsg("Driver not found");
     		return res;
        	
        }
        APIResponse res = new APIResponse();
	
         switch (trip.getStatus()) {
                case "CREATE":
                    trip.setDid(id);
                    driver.setStatus("Available");
                    trip.setStatus("START");
                    tripRepository.save(trip);
                    trip.setTriprate(Math.round(5 * 10.0) / 10.0);
                    
             		res.setMsg("Trip was assign");
             		return res;
        
                case "DENY":
                	
              		res.setMsg("Trip was deny");
              		return res;
                 

                default:
                	res.setMsg("Trip already assign");
              		return res;
               
            }
				
    }
	
	
	   public ResponseOrMessage<Trip> getCurrentTrip(Integer driverId) {
		   
		   Driver driver = driverRepository.findById(driverId).orElse(null);
		   int did = driver.getDid();
		   
			
	        if (driverId == did) {
	            Trip trip = tripRepository.findBydid(did).orElse(null);
	            String status = trip.getStatus();

	            if ((trip == null) || (status.equalsIgnoreCase("FINISH"))) {
	                return new ResponseOrMessage<>("Driver does not have active trips");
	            }
	            
	            else {
	            return new ResponseOrMessage<>("You have a Active Trip");
	            }

	        } else return new ResponseOrMessage<>("Wrong parameter");
	    }
	   
	   
	   
	 public APIResponse endTrip(SetGradeModel model) {

		        Trip trip = tripRepository.findById( model.getId()).orElse(null);
		        
		        System.out.println(model.getId());
		     
		      

		        if (trip == null) 
		        	{
		        	APIResponse res = new APIResponse();
		     		res.setMsg("Trip not found");
		     		return res;
		        	
		        	}

		        int driverID = trip.getDid();
		        
		        Driver driver = driverRepository.findById(driverID).orElse(null); 

		        if (driver == null) {
		        	APIResponse res = new APIResponse();
		     		res.setMsg("Driver not found");
		     		return res;
		        }

	            int passengerID = trip.getPid();
		        
		        Passenger passenger = passengerRepository.findById(passengerID).orElse(null);

		        if (passenger == null)
		        	{
		        	
		        	APIResponse res = new APIResponse();
		     		res.setMsg("Driver not found");
		     		return res;
		        	
		        	}

		        passenger.setRating((passenger.getRating() + model.getTriprate()) / 2);
		        System.out.println(model.getTriprate());

		        driver.setStatus("Availabe");
		        trip.setStatus("FINISH");
		        trip.setTriprate(model.getTriprate());
		        passengerRepository.save(passenger);
		        driverRepository.save(driver);
		        tripRepository.save(trip);
		        APIResponse res = new APIResponse();
	     		res.setMsg("Trip is over");
	     		return res;
		    }
	

}
