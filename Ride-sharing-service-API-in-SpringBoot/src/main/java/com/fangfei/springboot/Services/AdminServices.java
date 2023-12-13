package com.fangfei.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fangfei.springboot.Response.APIResponse;
import com.fangfei.springboot.beans.Admin;
import com.fangfei.springboot.beans.Driver;
import com.fangfei.springboot.beans.Passenger;
import com.fangfei.springboot.repositories.AdminRepository;
import com.fangfei.springboot.repositories.DriverRepository;
import com.fangfei.springboot.repositories.PassengerRepository;







@Component
@Service
public class AdminServices {
	
	@Autowired
    DriverRepository driverRepository;
	
    @Autowired
    PassengerRepository passengerRepository;
   
    
	
	@Autowired
	AdminRepository adminrep;
	
	
	
	
	public List<Admin> getAllAdmin() 
	{
		return adminrep.findAll();
	}
	
	
	
	
	
	public Admin getAdminbyID(int id)
	{
		List<Admin> admins = adminrep.findAll();
		Admin admin = null;
		for (Admin con:admins) {
			if(con.getId()==id)
				admin=con;
		}
		
		return admin;
	}
	
	

    
  
	public   APIResponse AddUsers(Admin admin) {
			 
			int id1=getMaxId();
			admin.setId(id1);
		    String phone = admin.getPhoneNumber();
		
		   Admin admin1 = adminrep.findById(id1).orElse(null); 
		   Admin admin2 = adminrep.findByphoneNumber(phone).orElse(null);	 
		 
		 
		 if(admin2 == null) {
			 if((admin.getPersonType()).equalsIgnoreCase("Passenger")) {
				  
				  Passenger  passenger= new Passenger(getMaxIdPassenger(),admin.getFirstName(), admin.getLastName(),admin.getPassword(), getrate(),admin.getPhoneNumber());
				  //passenger.setphone(admin1.getPhoneNumber());
				  
				  System.out.println(id1);
				  System.out.println(admin.getPhoneNumber());
				  System.out.println(passenger.getFirstName());
				  System.out.println(passenger.getphone());
				  
				  adminrep.save(admin);
				  passengerRepository.save(passenger);
					
				  APIResponse res = new APIResponse();
		   		  res.setMsg("Passenger add Succesfully");
		   		  return res;
		          
		          
		          
				}
				
				else if((admin.getPersonType()).equalsIgnoreCase("Driver")) {
					
				 Driver driver = new Driver(getMaxIdDriver(),admin.getFirstName(), admin.getLastName(),admin.getPassword(),getstatus(),getrate(),admin.getPhoneNumber());
		         driverRepository.save(driver);
		         adminrep.save(admin);
		        APIResponse res = new APIResponse();
		  		res.setMsg("Driver add Succesfully");
		  		return res;
					
				}
				
				else if((admin.getPersonType()).equalsIgnoreCase("Admin")) {
					
					
					adminrep.save(admin);
			        APIResponse res = new APIResponse();
			  		res.setMsg("Admin add Succesfully");
			  		return res;
					
					
					
				}
				
				else{
					
			        APIResponse res = new APIResponse();
			  		res.setMsg("Please Erite valid type of User: (Admin, Passenger or Driver");
			  		return res;
					
					
				}
			 
		   }
			 
		 if(phone.equals(admin2.getPhoneNumber())) {
		 System.out.println("phone is "+adminrep.findByphoneNumber(phone));	
		 APIResponse res = new APIResponse();
 		 res.setMsg("Phone Number Must be Unic for EveryUser"); 		 return res;	 
		 }
		 
	       
		 
		 
		 else {
		
		if((admin.getPersonType()).equalsIgnoreCase("Passenger")) {
		  
		  Passenger  passenger= new Passenger(getMaxIdPassenger(),admin.getFirstName(), admin.getLastName(),admin.getPassword(), getrate(),admin.getPhoneNumber());
		  //passenger.setphone(admin1.getPhoneNumber());
		  
		  System.out.println(id1);
		  System.out.println(admin.getPhoneNumber());
		  System.out.println(passenger.getFirstName());
		  System.out.println(passenger.getphone());
		  
		  adminrep.save(admin);
		  passengerRepository.save(passenger);
			
		  APIResponse res = new APIResponse();
   		  res.setMsg("Passenger add Succesfully");
   		  return res;
          
          
          
		}
		
		else if((admin.getPersonType()).equalsIgnoreCase("Driver")) {
			
		 Driver driver = new Driver(getMaxIdDriver(),admin.getFirstName(), admin.getLastName(),admin.getPassword(),getstatus(),getrate(),admin.getPhoneNumber());
         driverRepository.save(driver);
         adminrep.save(admin);
        APIResponse res = new APIResponse();
  		res.setMsg("Driver add Succesfully");
  		return res;
			
		}
		
		else if((admin.getPersonType()).equalsIgnoreCase("Admin")) {
			
			
			adminrep.save(admin);
	        APIResponse res = new APIResponse();
	  		res.setMsg("Admin add Succesfully");
	  		return res;
			
			
			
		}
		
		else{
			
	        APIResponse res = new APIResponse();
	  		res.setMsg("Please Erite valid type of User: (Admin, Passenger or Driver");
	  		return res;
			
			
		}
		
		 }
		
		

		
			
	}
	//utility method to get max id
	public int getMaxId() 
	{
		return adminrep.findAll().size()+1;
	}
	
	
	public List<Admin> getUserbyType(String adminType){
		
		List<Admin> admins = adminrep.findBypersonType(adminType);
		
		
		
	      return  admins;
	}
	
	public int getMaxIdPassenger() 
	{
		return passengerRepository.findAll().size()+1;
	}
	
	public int getMaxIdDriver() 
	{
		return driverRepository.findAll().size()+1;
	}
	
	public double getrate() {
		double r= 0.0;
		return r;
	}
	public String getstatus() {
		String status= "Available";
		return status;
	}
    

    public APIResponse deleteUsers(int UserId) {
    	 
    	Admin admin1 = adminrep.findById(UserId).get();
         if(admin1.getPersonType().equalsIgnoreCase("Driver")) {
        	 
        		String phone = admin1.getPhoneNumber();		
        		Driver driver = driverRepository.findByphone(phone).get();
        		
        		String phone2 = driver.getphone();
        		System.out.println(phone2);
        		System.out.println(phone);
     	
        		if((phone2.equalsIgnoreCase(phone))) {
        			    int did= driver.getDid();
        	        	driverRepository.deleteById(did);
    	                adminrep.deleteById(admin1.getId());
    	                APIResponse res = new APIResponse();
    	        		res.setMsg("Driver is deleted");
    	        		return res;	    	
        	        } 		
        	        
        		else{
        			
                	APIResponse res = new APIResponse();
            		res.setMsg("Driver not found!");
            		return res;
                	}
                
          }
         
         else if(admin1.getPersonType().equalsIgnoreCase("Passenger")) {
        	    String phone = admin1.getPhoneNumber();   
        	    Passenger passenger = passengerRepository.findByphone(phone).get();
        		
        		String phone2 =  passenger.getphone();
        		System.out.println(phone2);
        		System.out.println(phone);
     	
        		if((phone2.equalsIgnoreCase(phone))) {
        			 int pid= passenger.getId();
        			passengerRepository.deleteById(pid);
 	                adminrep.deleteById(admin1.getId());
 	                APIResponse res = new APIResponse();
 	        		res.setMsg("Passenger is deleted");
 	        		return res;	
        		}
              
        		else {
        			APIResponse res = new APIResponse();
            		res.setMsg("Passenger not found!");
            		return res;
        		}
        		
         }
         
         else if(admin1.getPersonType().equalsIgnoreCase("Admin")) {
             
        	 adminrep.deleteById(UserId);
             APIResponse res1 = new APIResponse();
     		 res1.setMsg("Admin is Deleted");
     		 return res1;
             
     		
        }
         
         else {
            	
            	APIResponse res2 = new APIResponse();
        		res2.setMsg("Wrong parameter");
        		return res2;
               
        }
    }
    
	
	

	
	

}
