package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Faculty;


public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	Faculty findByFacultyId(Integer id);
	Faculty findByFirstName(String firstName);
	
}
