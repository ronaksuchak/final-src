package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Schedule;



public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	List<Schedule> findByCalenderDate(LocalDate date);
	
}
