package com.app.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Calender;


public interface CalenderRepository extends JpaRepository<Calender, Integer> {
	
}
