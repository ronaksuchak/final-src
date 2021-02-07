package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Assignment;


public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	
}
