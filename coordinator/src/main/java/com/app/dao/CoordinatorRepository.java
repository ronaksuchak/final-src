package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Coordinator;


public interface CoordinatorRepository extends JpaRepository<Coordinator, Integer> {
	
}
