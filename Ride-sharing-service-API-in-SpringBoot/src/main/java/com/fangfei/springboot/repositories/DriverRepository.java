package com.fangfei.springboot.repositories;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fangfei.springboot.beans.Driver;




@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer>{
	
	 Optional<Driver> findByphone(String phone);
	

}



