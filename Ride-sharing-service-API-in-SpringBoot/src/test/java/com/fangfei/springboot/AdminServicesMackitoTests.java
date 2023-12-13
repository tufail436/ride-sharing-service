package com.fangfei.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fangfei.springboot.Services.AdminServices;
import com.fangfei.springboot.beans.Admin;
import com.fangfei.springboot.repositories.AdminRepository;
import com.fangfei.springboot.repositories.DriverRepository;
import com.fangfei.springboot.repositories.PassengerRepository;

@SpringBootTest(classes = {AdminServicesMackitoTests.class})
public class AdminServicesMackitoTests {
	
	@Mock
	AdminRepository adminrep;
	
	@Mock
    DriverRepository driverRepository;
	
	@Mock
    PassengerRepository passengerRepository;
	
	@InjectMocks
	AdminServices adminService;
	
	public List<Admin> alladmins;
	
	@Test
	@Order(1)
	public void test_getAllAdmin(){
		
		List<Admin> alladmins = new ArrayList<Admin>();
		
		alladmins.add(new Admin(1,"Admin","li","jie","1111","12345678"));
		alladmins.add(new Admin(2,"Passenger","li","wang","1433","017122460771"));
		
		when(adminrep.findAll()).thenReturn(alladmins);
		assertEquals(2,adminService.getAllAdmin().size());		
	}
	
	@Test
	@Order(2)
	public void test_getAdminbyID(){
		
		List<Admin> alladmins = new ArrayList<Admin>();
		
		alladmins.add(new Admin(1,"Admin","li","jie","1111","12345678"));
		alladmins.add(new Admin(2,"Passenger","li","wang","1433","017122460771"));
		int adminID= 1;
		
		when(adminrep.findAll()).thenReturn(alladmins);
		assertEquals(adminID,adminService.getAdminbyID(adminID).getId());
		

	}
	
	
	
	
    
	
	
	

}
