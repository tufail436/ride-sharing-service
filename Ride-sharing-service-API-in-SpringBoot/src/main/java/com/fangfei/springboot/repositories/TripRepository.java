package com.fangfei.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fangfei.springboot.beans.Trip;


@Repository
public interface TripRepository extends JpaRepository<Trip,Integer>{
	
	Optional<Trip> findBypid(int pid);
	
	Optional<Trip> findBydid(int did);
	
	List<Trip> findBystatus(String status);

}
