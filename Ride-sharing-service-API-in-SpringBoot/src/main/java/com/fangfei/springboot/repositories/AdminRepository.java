package com.fangfei.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fangfei.springboot.beans.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
	Optional<Admin> findByphoneNumber(String phone);
	List<Admin> findBypersonType(String type);

}
