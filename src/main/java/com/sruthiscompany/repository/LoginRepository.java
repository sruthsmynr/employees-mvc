package com.sruthiscompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sruthiscompany.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	public Login findByEmail(String email);

}
