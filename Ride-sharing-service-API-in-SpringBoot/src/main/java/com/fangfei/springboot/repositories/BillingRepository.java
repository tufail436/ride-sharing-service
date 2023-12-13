package com.fangfei.springboot.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fangfei.springboot.beans.Billing;


@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer> {
	   
}








