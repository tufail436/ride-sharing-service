package com.fangfei.springboot.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fangfei.springboot.beans.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	Optional<Passenger> findByphone(String phone);


}





